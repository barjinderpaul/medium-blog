package com.medium.CONSTANTS;

public enum ENV {
    DB_URL("jdbc:postgresql://localhost:5432/medium"),
    DB_USERNAME("postgres"),
    DB_PASSWORD("123456"),
    DB_DRIVER_CLASS_NAME("org.postgresql.Driver"),
    DB_DIALECT("org.hibernate.dialect.PostgreSQL82Dialect"),
    DB_SHOW_SQL("true"),
    PROPERTY_SHOW_SQL("hibernate.show_sql"),
    PROPERTY_DIALECT("hibernate.dialect");

    public final String value;

    ENV(String value){
        this.value = value;
    }
}
