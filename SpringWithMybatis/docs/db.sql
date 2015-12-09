

DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
    `id`           int(16)         NOT NULL    AUTO_INCREMENT,
    `name`         varchar(32)     NOT NULL,
    `desc`         varchar(128)    NOT NULL,
    `price`        double          NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
    `id`           int(16)         NOT NULL    AUTO_INCREMENT,
    `name`         varchar(32)     NOT NULL    UNIQUE,
    `password`     varchar(32)     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `t_user` VALUES ('1', 'admin', '21232F297A57A5A743894A0E4A801FC3');