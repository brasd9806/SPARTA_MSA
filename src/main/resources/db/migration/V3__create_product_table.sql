CREATE TABLE products
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category_id BIGINT,
    name        VARCHAR(255)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    stock       INT            NOT NULL DEFAULT 0,
    created_at  TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE orders
(
    id          BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id     BIGINT         NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    status      VARCHAR(20)    NOT NULL,
    created_at  TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_products
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_id   BIGINT         NOT NULL, -- FK: 어떤 주문에 속하는지
    product_id BIGINT         NOT NULL, -- FK: 어떤 상품인지
    quantity   INT            NOT NULL, -- 주문 수량
    price      DECIMAL(10, 2) NOT NULL  -- 주문 시점의 상품 가격
);

CREATE TABLE categories
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    parent_id  BIGINT                DEFAULT NULL, -- FK: 부모 카테고리의 id를 참조
    created_at TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product_options
(
    id               BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id       BIGINT         NOT NULL,              -- FK: 어떤 상품의 옵션인지
    name             VARCHAR(255)   NOT NULL,              -- 옵션 이름 (예: 색상, 사이즈)
    value            VARCHAR(255)   NOT NULL,              -- 옵션 값 (예: 블랙, 105)
    additional_price DECIMAL(10, 2) NOT NULL DEFAULT 0.00, -- 옵션 선택 시 추가 금액
    stock            INT            NOT NULL DEFAULT 0,    -- 옵션별 재고 (필요 시)
    created_at       TIMESTAMP               DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- 외래키 설정: 상품이 삭제되면 해당 옵션도 삭제되도록 CASCADE 설정 권장
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);