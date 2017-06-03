package ru.itis;

public class Producer extends Thread {
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isUsed()) {
                    System.out.println("Producer waiting");
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }
                System.out.println("Producer producing");
                product.produce();
                product.notify();
            }
        }
    }
}
