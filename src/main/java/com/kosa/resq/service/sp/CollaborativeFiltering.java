package com.kosa.resq.service.sp;

import java.util.*;

public class CollaborativeFiltering {
    private Map<String, Map<String, Integer>> userItemRatings;

    public CollaborativeFiltering() {
        // 사용자-아이템 평점 데이터를 저장하는 맵 초기화
        userItemRatings = new HashMap<>();
    }

    public void addUserRating(String user, String item, int rating) {
        // 사용자-아이템 평점 데이터 추가
        userItemRatings.computeIfAbsent(user, k -> new HashMap<>()).put(item, rating);
    }

    public double calculateSimilarity(Map<String, Integer> user1Ratings, Map<String, Integer> user2Ratings) {
        // 유사도 계산 (여기에서는 간단히 코사인 유사도를 사용)
        // 유사도 = (A와 B의 내적) / (A의 크기 * B의 크기)
        // 여기에서는 사용자가 평가한 아이템에 대해서만 유사도를 계산
        int dotProduct = 0;
        int normA = 0;
        int normB = 0;

        for (String item : user1Ratings.keySet()) {
            if (user2Ratings.containsKey(item)) {
                dotProduct += user1Ratings.get(item) * user2Ratings.get(item);
            }
            normA += Math.pow(user1Ratings.get(item), 2);
        }

        for (String item : user2Ratings.keySet()) {
            normB += Math.pow(user2Ratings.get(item), 2);
        }

        if (normA == 0 || normB == 0) {
            return 0; // 두 사용자 중 하나라도 평가한 아이템이 없을 경우 유사도는 0
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    public Map<String, Double> getTopNRecommendations(String user, int n) {
        // 주어진 사용자에게 상위 n개의 아이템을 추천하는 함수
        Map<String, Integer> userRatings = userItemRatings.get(user);
        Map<String, Double> itemScores = new HashMap<>();

        for (String otherUser : userItemRatings.keySet()) {
            if (!otherUser.equals(user)) {
                double similarity = calculateSimilarity(userRatings, userItemRatings.get(otherUser));

                for (Map.Entry<String, Integer> entry : userItemRatings.get(otherUser).entrySet()) {
                    String item = entry.getKey();
                    int rating = entry.getValue();

                    // 현재 사용자가 평가하지 않은 아이템만 고려
                    if (!userRatings.containsKey(item)) {
                        itemScores.put(item, itemScores.getOrDefault(item, 0.0) + similarity * rating);
                    }
                }
            }
        }

        // 추천 아이템을 유사도 순으로 정렬하여 반환
        return itemScores.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()))
                .limit(n)
                .collect(HashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), HashMap::putAll);
    }

    public static void main(String[] args) {
        CollaborativeFiltering cf = new CollaborativeFiltering();

        // 사용자-아이템 평점 데이터 추가 (예제 데이터)
        cf.addUserRating("user1", "item1", 5);
        cf.addUserRating("user1", "item2", 4);
        cf.addUserRating("user1","item5",1);
        cf.addUserRating("user2", "item1", 3);
        cf.addUserRating("user2", "item3", 2);
        cf.addUserRating("user3","item1",5);

        // 사용자에게 상위 2개의 아이템을 추천
        Map<String, Double> recommendations = cf.getTopNRecommendations("user3", 2);

        // 결과 출력
        System.out.println("추천 아이템:");
        for (String item : recommendations.keySet()) {
            System.out.println(item + " (점수: " + recommendations.get(item) + ")");
        }
    }
}