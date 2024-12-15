public class Omega {
    public String getUpperCaseInitials(String inputText) {
        if (inputText == null) {
            throw new NullPointerException();
        }
        String[] words = inputText.split("\\s+");
        StringBuilder initials = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                initials.append(word.substring(0, 1).toUpperCase());
            }
        }
        return initials.toString();
    }

    public String findWordWithMostLettersI(String inputText) {
        String[] words = inputText.split("\\s+");
        String wordWithMaxI = "";
        int maxICount = 0;

        for (String word : words) {
            int currentICount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Character.toLowerCase(word.charAt(i)) == 'и') {
                    currentICount++;
                }
            }

            if (currentICount > maxICount) {
                maxICount = currentICount;
                wordWithMaxI = word;
            }
        }
        return wordWithMaxI;
    }

    public int calculateMaxDiagonalSum(int[][] matrix) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][matrix.length - 1 - i];
        }
        return Math.max(primaryDiagonalSum, secondaryDiagonalSum);
    }
}