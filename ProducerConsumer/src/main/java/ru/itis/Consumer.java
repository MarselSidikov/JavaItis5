package ru.itis;

public class Consumer extends Thread {
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    public void run() {
        while (true) {
            synchronized (product) {
                while (!product.isReady()) {
                    System.out.println("Consumer waiting");
                    try {
                        // уходим в ожидание на product
                        // пока другой поток не скажет,
                        // что мы можем этим пользоваться
                        product.wait();
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                }
                System.out.println("Consumer using");
                product.use();
                // оповещаем другие потоки о том,
                // что им пользоваться
                product.notify();
            }
        }
    }
}
