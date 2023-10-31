package com.kosa.resq.service.sp;

public class CosineSimilarity {
    public static void main(String[] args){
        // 두 벡터 정의
        double[] vectorA = {1, 2, 4, 3};
        double[] vectorB = {1, 2, 3, 4};

        // 코사인 유사도
        double similarity = cosineSimilarity(vectorA, vectorB);

        // 결과 출력
        System.out.println("코사인 유사도: " + similarity);
    }
    /**두 벡터의 코사인 유사도를 계산하는 함수*/
    public static double cosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += vectorA[i] * vectorA[i];
            normB += vectorB[i] * vectorB[i];
        }

        if (normA == 0 || normB == 0) {
            return 0.0; // 분모가 0인 경우 유사도는 0
        } else {
            return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
        }
    }
}
