package ru.itis;

// Когда продукт создали - он готов к использованию, но не использован
// Когда продукт использовали - он не готов к использованию, но его можно подготовить
public class Product {
    // статус продукта - готовность
    private boolean status = false;

    public boolean isReady() {
        return status;
    }

    // если продукт был готов, то он не использован
    // если продукт не готов, то он - использован
    public boolean isUsed() {
        return !status;
    }

    public void produce() {
        this.status = true;
    }

    public void use() {
        this.status = false;
    }
}
