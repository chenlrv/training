package Sandbox.Threads;

import java.util.Arrays;

public class ThreadsPower {
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] resultMatrix = new int[2][2];

    ThreadsPower(int[][] matrixA, int[][] matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    private void computeMultiplyMatricesOneThread() {
        long start = System.nanoTime();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                resultMatrix[i][j] = matrixA[i][0] * matrixB[0][j] + matrixA[i][1] * matrixB[1][j];
            }
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time passed: " + timeElapsed);
        System.out.println("Result matrix is: " + Arrays.deepToString(resultMatrix));
    }

    private void computeMultiplyMatricesMultiThreaded() throws InterruptedException {
        long start = System.nanoTime();
        Thread t1 =  new Thread(new ComputeSquareInMatrix(0, 0));
        Thread t2 =  new Thread(new ComputeSquareInMatrix(0, 1));
        Thread t3 =  new Thread(new ComputeSquareInMatrix(1, 0));
        Thread t4 =  new Thread(new ComputeSquareInMatrix(1, 1));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time passed: " + timeElapsed);
        System.out.println("Result matrix is: " + Arrays.deepToString(resultMatrix));
    }

    class ComputeSquareInMatrix implements Runnable {
        int i;
        int j;

        public ComputeSquareInMatrix(int i, int j) {
            this.i = i;
            this.j = j;
        }


        @Override
        public void run() {
            resultMatrix[i][j] = matrixA[i][0] * matrixB[0][j] + matrixA[i][1] * matrixB[1][j];
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int[][] matrixA = new int[2][2];
        int[][] matrixB = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrixA[i][j] = i * j + 3;
                matrixB[i][j] = i * 5 + j;
            }
        }

        System.out.println("Matrix A is: " + Arrays.deepToString(matrixA));
        System.out.println("Matrix B is: " + Arrays.deepToString(matrixB));

        ThreadsPower threadsPower = new ThreadsPower(matrixA, matrixB);
        threadsPower.computeMultiplyMatricesOneThread();
        Thread.sleep(3000);
        threadsPower.computeMultiplyMatricesMultiThreaded();

    }
}
