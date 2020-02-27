import java.util.*;

public class Level1 {
    public static boolean Football(int[] F, int N) {
        int[] newF = Arrays.copyOf(F, N);
        int[] sortF = Arrays.copyOf(F, N);
        Arrays.sort(sortF);
        if (Arrays.equals(sortF, F)) {
            return true;
        }

        for (int i = 0; i < N - 1; i++) {
            if (F[i] > F[i + 1]) {
                for (int j = N - 1; j > i; j--) {
                    if (F[j] < F[j - 1]) {
                        newF[j] = F[i];
                        newF[i] = F[j];
                        if (Arrays.equals(sortF, newF)) {
                            return true;
                        } else {
                            if (i == (N - 2)) return false;
                            break;
                        }
                    }
                }
                for (int j = i + 1; j < N - 1; j++) {
                    if (F[j] < F[j + 1]) {
                        int[] newNewF = Arrays.copyOfRange(F, i, j + 1);
                        Arrays.sort(newNewF);
                        for (int k = i, kk = 0; k < j; k++, kk++) {
                            newF[k] = newNewF[kk];
                        }
                        return Arrays.equals(sortF, newF);
                    }
                }
                return true;
            }
        }
        return false;
    }
}