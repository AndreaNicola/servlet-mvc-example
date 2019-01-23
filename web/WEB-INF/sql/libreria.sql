

DROP TABLE IF EXISTS `autore`;
CREATE TABLE `autore` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cognome` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

LOCK TABLES `autore` WRITE;
INSERT INTO `autore` VALUES (1,'alice','cecchetti'),(2,'frederik','batuna'),(3,'alessandro','oliva'),(4,'mattia','cutrupi'),(5,'lorenzo','zani'),(6,'margaret','lungo');
UNLOCK TABLES;


DROP TABLE IF EXISTS `genere`;
CREATE TABLE `genere` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

LOCK TABLES `genere` WRITE;
INSERT INTO `genere` VALUES (2,'fantasy'),(3,'horror'),(4,'romanzo'),(1,'thriller');
UNLOCK TABLES;


DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `titolo` varchar(100) NOT NULL,
  `descrizione` varchar(100) NOT NULL,
  `autore_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `autore_id` (`autore_id`),
  CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`autore_id`) REFERENCES `autore` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

LOCK TABLES `libro` WRITE;
INSERT INTO `libro` VALUES (1,'libro1','lorem ipsum',1),(2,'libro2','lorem ipsum',2),(3,'libro3','lorem ipsum',3),(4,'libro4','lorem ipsum',4),(5,'libro5','lorem ipsum',5),(6,'libro6','lorem ipsum',6),(7,'libro7','lorem ipsum',1),(8,'libro8','lorem ipsum',2),(9,'libro9','lorem ipsum',3),(10,'libro10','lorem ipsum',4),(11,'libro11','lorem ipsum',5),(12,'libro12','lorem ipsum',6),(13,'libro13','lorem ipsum',1),(14,'libro14','lorem ipsum',2),(15,'libro15','lorem ipsum',3),(16,'libro16','lorem ipsum',4),(17,'libro17','lorem ipsum',5),(18,'libro18','lorem ipsum',6);
UNLOCK TABLES;

DROP TABLE IF EXISTS `libro_genere`;
CREATE TABLE `libro_genere` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `libro_id` int(11) NOT NULL,
  `genere_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `libro_id` (`libro_id`),
  KEY `genere_id` (`genere_id`),
  CONSTRAINT `libro_genere_ibfk_1` FOREIGN KEY (`libro_id`) REFERENCES `libro` (`ID`),
  CONSTRAINT `libro_genere_ibfk_2` FOREIGN KEY (`genere_id`) REFERENCES `genere` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

LOCK TABLES `libro_genere` WRITE;
INSERT INTO `libro_genere` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,2),(7,7,2),(8,8,2),(9,9,2),(10,10,2),(11,11,3),(12,12,3),(13,13,3),(14,14,3),(15,15,4),(16,16,4),(17,17,4),(18,18,4);
UNLOCK TABLES;

