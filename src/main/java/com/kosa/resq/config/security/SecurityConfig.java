package com.kosa.resq.config.security;

import com.kosa.resq.config.security.exception.CustomAuthFailureHandler;
import com.kosa.resq.config.security.exception.CustomAuthSuccessHandler;
import com.kosa.resq.config.security.filter.CustomAuthenticationFilter;
import com.kosa.resq.config.security.filter.JwtAuthorizationFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("관리자") // 관리자 권한이 있는 사람만 접근 가능
                .anyRequest().permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .loginPage("/login")  // 로그인 페이지 URL
                .defaultSuccessUrl("/dashboard")
                .and()
                .cors();

//                .logout()
//                .logoutUrl("/logout")  // 로그아웃 URL
//                .logoutSuccessUrl("/login")  // 로그아웃 성공 후 이동할 페이지
//                .invalidateHttpSession(true)  // 세션 무효화
//                .deleteCookies("JSESSIONID");  // 세션 쿠키 삭제

        // 다음과 같이 필터를 추가하고 설정할 수 있습니다.
        http.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.cors().configurationSource(corsConfigurationSource());
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.applyPermitDefaultValues(); // 기본 CORS 허용 설정 적용
        corsConfig.addAllowedMethod("DELETE");
        corsConfig.addAllowedMethod("PUT");
        corsConfig.addAllowedMethod("POST");
        corsConfig.addAllowedMethod("PATCH");
        corsConfig.addAllowedMethod("GET");
        corsConfig.addAllowedOrigin("http://localhost:3000"); // 클라이언트 앱의 출처(origin)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return source;
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 정적 자원에 대해서 Security를 적용하지 않음으로 설정
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .httpBasic().disable()
//                // [STEP1] 서버에 인증정보를 저장하지 않기에 csrf를 사용하지 않는다.
//                .csrf().disable()
//
//                // [STEP2] 토큰을 활용하는 경우 모든 요청에 대해 '인가'에 대해서 적용
//                .authorizeHttpRequests(authz -> authz
//                        .antMatchers("/admin/**").hasRole("ADMIN") // 관리자 권한이 있는 사람만 접근 가능
////                        .antMatchers("/**").hasAnyRole("사용자","관리자")  //
//                        .anyRequest().permitAll()
//                )
//
//                // [STEP3] Spring Security JWT Filter Load
//                .addFilterBefore(jwtAuthorizationFilter(), BasicAuthenticationFilter.class)
//
//                // [STEP4] Session 기반의 인증기반을 사용하지 않고 추후 JWT를 이용하여서 인증 예정
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//                .and()
//                // [STEP5] form 기반의 로그인에 대해 비 활성화하며 커스텀으로 구성한 필터를 사용한다.
//                .formLogin().disable()
//
//                // [STEP6] Spring Security Custom Filter Load - Form '인증'에 대해서 사용
//                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .cors().configurationSource(corsConfigurationSource());
//        // [STEP7] 최종 구성한 값을 사용함.
//        return http.build();
//
//    }
    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(customAuthenticationProvider());
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(bCryptPasswordEncoder());
    }
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
        customAuthenticationFilter.setFilterProcessesUrl("/api/v1/user/login");     // 접근 URL
        customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler());    // '인증' 성공 시 해당 핸들러로 처리를 전가한다.
        customAuthenticationFilter.setAuthenticationFailureHandler(customLoginFailureHandler());    // '인증' 실패 시 해당 핸들러로 처리를 전가한다.
        customAuthenticationFilter.afterPropertiesSet();
        return customAuthenticationFilter;
    }
    @Bean
    public CustomAuthSuccessHandler customLoginSuccessHandler() {
        return new CustomAuthSuccessHandler();
    }
    @Bean
    public CustomAuthFailureHandler customLoginFailureHandler() {
        return new CustomAuthFailureHandler();
    }
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.applyPermitDefaultValues();
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // 클라이언트 출처
        config.setAllowedOrigins(Arrays.asList("http://192.168.0.177:3000")); // 클라이언트 출처
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
