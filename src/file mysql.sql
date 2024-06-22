CREATE TABLE `appchat`.`login` (
  `username` NVARCHAR(45) NOT NULL primary key,
  `password` VARCHAR(45) NOT NULL,
  `phone` 	VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL;
--
SELECT * FROM appchat.login;
----
delete from `appchat`.`login`
INSERT INTO `appchat`.`login` (`username`, `password`) VALUES ('huyen', '27105');
-----
DELETE FROM `appchat`.`login` 
WHERE (username="conan") AND (password=12345);
select * FROM `appchat`.`login`
WHERE (username='viet') AND (password=12345);
USE appchat;
SELECT * FROM login
CREATE TABLE `appchat`.`account` (
  `UserName` VARCHAR(45) NOT NULL,
  `Pass` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserName`));
SELECT * FROM appchat.account;
DELETE FROM `appchat`.`account` 
WHERE (UserName="viet") AND (Pass="827ccb0eea8a706c4c34a16891f84e7b") and (Email="0329190334") and (Phone = "viet@gmail.com");
