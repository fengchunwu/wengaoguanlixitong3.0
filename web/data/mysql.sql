CREATE TABLE `tabel_usersinfo` (
  `username` varchar(200) NOT NULL,
  `name` varchar(1000) DEFAULT NULL,
  `sex` varchar(1000) DEFAULT NULL,
  `birthday` varchar(1000) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `phone` varchar(1000) DEFAULT NULL,
  `referrer` varchar(1000) DEFAULT NULL,
  `branch` varchar(1000) DEFAULT NULL,
  `community` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_caogao` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  `author` varchar(1000) DEFAULT NULL,
  `submittime` varchar(1000) DEFAULT NULL,
  `state` varchar(1000) DEFAULT NULL,
  `essay` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_common` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  `essay` varchar(1000) DEFAULT NULL,
  `submittime` varchar(1000) DEFAULT NULL,
  `common` int(255) DEFAULT NULL,
  `essayID` int(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_draft` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  `author` varchar(1000) DEFAULT NULL,
  `deadline` varchar(1000) DEFAULT NULL,
  `essay` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_draftinfo` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  `author` varchar(1000) DEFAULT NULL,
  `deadline` varchar(1000) DEFAULT NULL,
  `state` varchar(1000) DEFAULT NULL,
  `support` varchar(1000) DEFAULT NULL,
  `object` varchar(1000) DEFAULT NULL,
  `submittime` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_referrer` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `referrer` varchar(1000) DEFAULT NULL,
  `position` varchar(1000) DEFAULT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `company` varchar(1000) DEFAULT NULL,
  `phone` varchar(1000) DEFAULT NULL,
  `email` varchar(1000) DEFAULT NULL,
  `recommended` varchar(1000) DEFAULT NULL,
  `reason` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_rule` (
  `ID` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  `author` varchar(1000) DEFAULT NULL,
  `time` varchar(1000) DEFAULT NULL,
  `essay` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `table_users1` (
`ID` int(255) NOT NULL AUTO_INCREMENT,
`username` varchar(200) DEFAULT NULL,
`password` varchar(1000) DEFAULT NULL,
`status` varchar(1000) DEFAULT NULL,
`privilege` varchar(1000) DEFAULT NULL, PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFALUT CHARSET=utf8;