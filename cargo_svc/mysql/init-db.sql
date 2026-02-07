-- Run this script in MySQL to set up the database
-- Command: mysql -u root -p < init-db.sql
-- Create database
CREATE DATABASE IF NOT EXISTS cargo_db;
-- Create user (if not exists) and grant privileges
CREATE USER IF NOT EXISTS 'cargo_user'@'%' IDENTIFIED BY 'cargo_password';
GRANT ALL PRIVILEGES ON cargo_db.* TO 'cargo_user'@'%';
FLUSH PRIVILEGES;
