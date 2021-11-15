CREATE SCHEMA IF NOT EXISTS event_agency DEFAULT CHARACTER SET utf8 ;
USE event_agency;

DROP TABLE IF EXISTS animator;
DROP TABLE IF EXISTS agency_type;
DROP TABLE IF EXISTS agency;
DROP TABLE IF EXISTS event_address;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS price;
DROP TABLE IF EXISTS agency_animator;
DROP TABLE IF EXISTS order_client;

CREATE TABLE IF NOT EXISTS animator (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  age INT NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS agency_type (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS agency (
  id INT NOT NULL AUTO_INCREMENT,
  agency_type_id INT NOT NULL,
  name_agency VARCHAR(45) NULL,
  PRIMARY KEY (id),
  INDEX fk_agency_agency_type_idx (agency_type_id ASC),
  CONSTRAINT fk_agency_agency_type
    FOREIGN KEY (agency_type_id)
    REFERENCES agency_type (id));


CREATE TABLE IF NOT EXISTS event_address (
  id INT NOT NULL AUTO_INCREMENT,
  street VARCHAR(45) NOT NULL,
  postal_code VARCHAR(10) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS event (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  event_duration TIME NOT NULL,
  date_of_the_event DATE NOT NULL,
  event_address_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_event_event_address_idx (event_address_id ASC),
  CONSTRAINT fk_event_event_address
    FOREIGN KEY (event_address_id)
    REFERENCES event_address (id));


CREATE TABLE IF NOT EXISTS client (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS price (
  id INT NOT NULL AUTO_INCREMENT,
  salary DECIMAL(10,2) NOT NULL,
  agency_salary DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (id));


CREATE TABLE IF NOT EXISTS agency_animator (
  id INT NOT NULL AUTO_INCREMENT,
  agency_id INT NOT NULL,
  animator_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_agency_animator_agency1_idx (agency_id ASC),
  INDEX fk_agency_animator_animator1_idx (animator_id ASC),
  CONSTRAINT fk_agency_animator_agency1
    FOREIGN KEY (agency_id)
    REFERENCES agency (id),
  CONSTRAINT fk_agency_animator_animator1
    FOREIGN KEY (animator_id)
    REFERENCES animator (id));


CREATE TABLE IF NOT EXISTS order_client (
  id INT NOT NULL AUTO_INCREMENT,
  animator_id INT NOT NULL,
  agency_id INT NOT NULL,
  event_id INT NOT NULL,
  client_id INT NOT NULL,
  price_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_order_client_agency_idx (agency_id ASC),
  INDEX fk_order_client_event_idx (event_id ASC),
  INDEX fk_order_client_client_idx (client_id ASC),
  INDEX fk_order_client_animator_idx (animator_id ASC),
  INDEX fk_order_client_price_idx (price_id ASC),
  CONSTRAINT fk_order_client_agency
    FOREIGN KEY (agency_id)
    REFERENCES agency (id),
  CONSTRAINT fk_order_client_event
    FOREIGN KEY (event_id)
    REFERENCES event (id),
  CONSTRAINT fk_order_client_client
    FOREIGN KEY (client_id)
    REFERENCES client (id),
  CONSTRAINT fk_order_client_animator
    FOREIGN KEY (animator_id)
    REFERENCES animator (id),
  CONSTRAINT fk_order_client_price
    FOREIGN KEY (price_id)
    REFERENCES price (id));
