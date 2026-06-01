CREATE TABLE IF NOT EXISTS users(
                                    id UUID PRIMARY KEY ,
                                    user_name VARCHAR(50) NOT NULL,
                                    phone_number VARCHAR(25) NOT NULL,
                                    email_address VARCHAR(30) NOT NULL UNIQUE,
                                    status VARCHAR(30),
                                    created_at TIMESTAMP DEFAULT NOW(),
                                    updated_at TIMESTAMP DEFAULT NOW()
);


CREATE TABLE IF NOT EXISTS addresses(
                                        id UUID PRIMARY KEY ,
                                        user_id UUID REFERENCES users(id) ON DELETE CASCADE,
                                        label VARCHAR(50),
                                        street VARCHAR(50) NOT NULL,
                                        house_number VARCHAR(50) NOT NULL,
                                        box_number INTEGER,
                                        city VARCHAR(30),
                                        postal_code INTEGER,
                                        country VARCHAR(30),
                                        is_default BOOLEAN,
                                        created_at TIMESTAMP DEFAULT NOW(),
                                        updated_at TIMESTAMP DEFAULT NOW()
);

CREATE INDEX IF NOT EXISTS idx_addresses_user_id ON addresses(user_id);
