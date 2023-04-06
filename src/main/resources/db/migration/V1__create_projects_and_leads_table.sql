CREATE TABLE IF NOT EXISTS projects(
    id INT GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(2000) UNIQUE NOT NULL,
    description VARCHAR(4000) NOT NULL,
    hosted VARCHAR(2000) NOT NULL,
    image_urls VARCHAR(4000),
    status VARCHAR(255) NOT NULL,
    deleted BOOLEAN,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255),
    deleted_by VARCHAR(255),
    created_on timestamptz NOT NULL,
    updated_on timestamptz,
    deleted_on timestamptz,
    CONSTRAINT projects_pk PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS leads(
    id INT GENERATED ALWAYS AS IDENTITY,
    project_id INT,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    deleted BOOLEAN,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255),
    deleted_by VARCHAR(255),
    created_on timestamptz NOT NULL,
    updated_on timestamptz,
    deleted_on timestamptz,
    CONSTRAINT leads_pk PRIMARY KEY(id),
    CONSTRAINT projects_leads_fk FOREIGN KEY(project_id) REFERENCES projects(id)
);