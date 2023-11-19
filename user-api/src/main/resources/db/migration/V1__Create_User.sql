CREATE TABLE users (
    usr_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    usr_name VARCHAR(200) NOT NULL,
    usr_birth DATE NOT NULL,
    usr_login VARCHAR(50) UNIQUE NOT NULL,
    usr_password VARCHAR(255) NOT NULL,
    usr_status INT NOT NULL,
    usr_cpf VARCHAR(11) NOT NULL,
    usr_street VARCHAR(255) NOT NULL,
    usr_city VARCHAR(255) NOT NULL,
    usr_state VARCHAR(2) NOT NULL,
    usr_zip VARCHAR(10) NOT NULL
);
