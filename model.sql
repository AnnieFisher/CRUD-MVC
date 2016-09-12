-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema build_a_board
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `build_a_board` ;

-- -----------------------------------------------------
-- Schema build_a_board
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `build_a_board` DEFAULT CHARACTER SET utf8 ;
USE `build_a_board` ;

-- -----------------------------------------------------
-- Table `wheels`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wheels` ;

CREATE TABLE IF NOT EXISTS `wheels` (
  `idwheels` INT NOT NULL AUTO_INCREMENT,
  `wheels_rank` INT NULL,
  `wheels_brand` VARCHAR(45) NULL,
  PRIMARY KEY (`idwheels`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `bearings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bearings` ;

CREATE TABLE IF NOT EXISTS `bearings` (
  `idbearings` INT NOT NULL AUTO_INCREMENT,
  `bearings_rank` INT NULL,
  `bearings_brand` VARCHAR(45) NULL,
  PRIMARY KEY (`idbearings`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `trucks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trucks` ;

CREATE TABLE IF NOT EXISTS `trucks` (
  `idtrucks` INT NOT NULL AUTO_INCREMENT,
  `trucks_rank` INT NULL,
  `trucks_brand` VARCHAR(45) NULL,
  PRIMARY KEY (`idtrucks`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `decks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `decks` ;

CREATE TABLE IF NOT EXISTS `decks` (
  `iddecks` INT NOT NULL AUTO_INCREMENT,
  `decks_brand` VARCHAR(45) NULL,
  `decks_name` VARCHAR(45) NULL,
  `urls` VARCHAR(100) NULL,
  PRIMARY KEY (`iddecks`))
ENGINE = InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Table `build`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `build` ;

CREATE TABLE IF NOT EXISTS `build` (
  `idbuild` INT NOT NULL AUTO_INCREMENT,
  `idwheels` INT NOT NULL,
  `idbearings` INT NOT NULL,
  `idtrucks` INT NOT NULL,
  `iddecks` INT NOT NULL,
  PRIMARY KEY (`idbuild`),
  INDEX `idwheels_idx` (`idwheels` ASC),
  INDEX `idbearings_idx` (`idbearings` ASC),
  INDEX `idtrucks_idx` (`idtrucks` ASC),
  INDEX `iddecks_idx` (`iddecks` ASC),
  CONSTRAINT `idwheels`
    FOREIGN KEY (`idwheels`)
    REFERENCES `wheels` (`idwheels`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idbearings`
    FOREIGN KEY (`idbearings`)
    REFERENCES `bearings` (`idbearings`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idtrucks`
    FOREIGN KEY (`idtrucks`)
    REFERENCES `trucks` (`idtrucks`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `iddecks`
    FOREIGN KEY (`iddecks`)
    REFERENCES `decks` (`iddecks`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO board;
 DROP USER board;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'board' IDENTIFIED BY 'board';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'board';
SET SQL_MODE = '';
GRANT USAGE ON *.* TO board@localhost;
 DROP USER board@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'board'@'localhost' IDENTIFIED BY 'board';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'board'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `wheels`
-- -----------------------------------------------------
START TRANSACTION;
USE `build_a_board`;
INSERT INTO `wheels` (`idwheels`, `wheels_rank`, `wheels_brand`) VALUES (1, 1, 'Bones');
INSERT INTO `wheels` (`idwheels`, `wheels_rank`, `wheels_brand`) VALUES (2, 2, 'Spitfire');
INSERT INTO `wheels` (`idwheels`, `wheels_rank`, `wheels_brand`) VALUES (3, 3, 'Kryptonics');
INSERT INTO `wheels` (`idwheels`, `wheels_rank`, `wheels_brand`) VALUES (4, 4, 'Ricta');
INSERT INTO `wheels` (`idwheels`, `wheels_rank`, `wheels_brand`) VALUES (5, 5, 'Pig');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bearings`
-- -----------------------------------------------------
START TRANSACTION;
USE `build_a_board`;
INSERT INTO `bearings` (`idbearings`, `bearings_rank`, `bearings_brand`) VALUES (1, 1, 'Bones');
INSERT INTO `bearings` (`idbearings`, `bearings_rank`, `bearings_brand`) VALUES (2, 2, 'Swiss Ceramics Reds');
INSERT INTO `bearings` (`idbearings`, `bearings_rank`, `bearings_brand`) VALUES (3, 3, 'China Bone Reds');
INSERT INTO `bearings` (`idbearings`, `bearings_rank`, `bearings_brand`) VALUES (4, 4, 'Bones Swiss Labyrinth');
INSERT INTO `bearings` (`idbearings`, `bearings_rank`, `bearings_brand`) VALUES (5, 5, 'Rush Abec 9');

COMMIT;


-- -----------------------------------------------------
-- Data for table `trucks`
-- -----------------------------------------------------
START TRANSACTION;
USE `build_a_board`;
INSERT INTO `trucks` (`idtrucks`, `trucks_rank`, `trucks_brand`) VALUES (1, 1, 'Independent');
INSERT INTO `trucks` (`idtrucks`, `trucks_rank`, `trucks_brand`) VALUES (2, 2, 'Thunder');
INSERT INTO `trucks` (`idtrucks`, `trucks_rank`, `trucks_brand`) VALUES (3, 3, 'Venture');
INSERT INTO `trucks` (`idtrucks`, `trucks_rank`, `trucks_brand`) VALUES (4, 4, 'Tensor');
INSERT INTO `trucks` (`idtrucks`, `trucks_rank`, `trucks_brand`) VALUES (5, 5, 'Silver');

COMMIT;


-- -----------------------------------------------------
-- Data for table `decks`
-- -----------------------------------------------------
START TRANSACTION;
USE `build_a_board`;
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (1, 'Plan B', 'Duffy Beer Can', 'http://skateparkoftampa.com/spot/productimages/colors/1_74678.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (2, 'Plan B', 'Felipe OG RMX', 'https://www.westsideskateshop.com/PDGImages/felipe%20og%20rmx.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (3, 'Plan B', 'Felipe Royalty', 'https://www.planbskateboards.com/media/filter/l/img/pdprgfro_ast_1.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (4, 'Plan B', 'Felipe SBS', 'https://www.warehouseskateboards.com/images/products/preview/1DPLNGUSSBS800S.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (5, 'Plan B', 'Joslin Black Magic', 'https://www.planbskateboards.com/media/filter/l/img/pdprgjbm_ast_1.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (6, 'Plan B', 'Joslin Crawler', 'https://www.planbskateboards.com/media/filter/l/img/pdprgjcr_ast_1.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (7, 'Plan B', 'Joslin RipShred', 'http://www.planbskateboards.com/media/filter/l/img/pdprfjws_ast_1.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (8, 'Plan B', 'Joslin SLCD', 'https://www.planbskateboards.com/media/filter/l/img/pdprgjsm_ast_1.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (9, 'Plan B', 'Team Torn Yellow', 'http://skatelyboardshop.com/img/shop/product/1/d/crop_rotate_170/1dpln0torn87kby.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (10, 'Plan B', 'Sheckler Warrior', 'http://www.easternskatesupply.com/Z/1DPLNSHEWRS82WR.png');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (11, 'Element', 'EvanWays', 'http://img.skatewarehouse.com/watermark/rs.php?path=ELESWDK-1.jpg&nw=435');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (12, 'Element', 'WestGate Ways', 'https://eu.elementbrand.com/media/filter/l/img/04dcpvelpp_0001.jpg?1471484381');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (13, 'Element', 'WestGate', 'https://us.elementbrand.com/media/filter/l/img/bdprdwop_ast_1_2.jpg?1443208210');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (14, 'Element', 'WestGate Bingo', 'https://eu.elementbrand.com/media/filter/l/img/brd_bingo_westgate.jpg?1462982282');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (15, 'Element', 'MardarsWay', 'https://us.elementbrand.com/media/filter/m/img/bdprgmwy_ast_1.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (16, 'Element', 'Link8', 'http://eu.elementbrand.com/media/filter/l/img/element_deck_link_8.jpg?1466758578');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (17, 'Element', 'Evan Sprites', 'https://us.elementbrand.com/media/filter/l/img/bdprfesp_ast_1_evan_sprites_8_2.jpg?1457774104');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (18, 'Element', 'Barbee Bronze', 'https://eu.elementbrand.com/media/filter/l/img/brd_tmoe_barbee.jpg?1463066883');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (19, 'Element', 'Mark AppleYard Totems', 'http://skateparkoftampa.com/spot/productimages/colors/1_53635.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (20, 'Element', 'Nyjah Bingo', 'http://img.skatewarehouse.com/watermark/rs.php?path=ELNHBIDK-1.jpg&nw=435');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (21, 'Zero', 'American Punk', 'https://www.warehouseskateboards.com/images/products/preview/1DZER0AMPK85WRB.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (22, 'Zero', 'Disorder', 'http://www.socialskateboarding.com/assets/products/17515/full/1dzer0diso850gk.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (23, 'Zero', 'Otis Cruiser', 'https://cdn.skatedeluxe.com/images/product_images/original_images/93038_1_Zero_OtisCruiser85.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (24, 'Zero', 'Thomas Zero', 'http://skateparkoftampa.com/spot/productimages/colors/1_28326.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (25, 'Zero', 'Sandoval Zero', 'http://skateparkoftampa.com/spot/productimages/colors/1_61712.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (26, 'Zero', 'Burman Zero', 'http://skateparkoftampa.com/spot/productimages/colors/1_62496.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (27, 'Zero', 'Brockman', 'http://www.nativeskatestore.co.uk/images/zero-brockman-bottled-violence-skateboard-deck-8-0-p7630-15129_zoom.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (28, 'Zero', 'Filmstrip Photo Issue', 'https://www.ocdskateshop.com.au/media/catalog/product/cache/1/small_image/275x/9df78eab33525d08d6e5fb8d27136e95/z/e/zero-filmstrip-photo-issue-cruiser-skateboard-deck_1.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (29, 'Zero', 'American Zero', 'http://skateparkoftampa.com/spot/productimages/colors/1_1653.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (30, 'Zero', 'Eyeball', 'http://www.easternskatesupply.com/Z/1DZER0EYBL837KB.png');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (31, 'Girl', 'Brandon Beibel', 'http://www.nativeskatestore.co.uk/images/girl-brandon-biebel-owen-s-world-skateboard-deck-7-875-p12783-28059_zoom.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (32, 'Girl', 'Cory Kennedy', 'http://skateparkoftampa.com/spot/productimages/colors/1_53899.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (33, 'Girl', 'Mike Carroll', 'http://skateparkoftampa.com/spot/productimages/colors/1_60450.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (34, 'Girl', 'Mike Mo', 'http://scene7.zumiez.com/is/image/zumiez/pdp_hero/Girl-MikeMo-Sign-Here-7.75%26quot%3B--Skateboard-Deck-_236788.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (35, 'Girl', 'Rick Howard', 'http://www.nativeskatestore.co.uk/images/girl-rick-howard-half-half-skateboard-deck-8-5-p10560-21804_zoom.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (36, 'Girl', 'Rick Mccrank', 'http://skateparkoftampa.com/spot/productimages/colors/1_69250.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (37, 'Girl', 'Sean Malto', 'http://skateparkoftampa.com/spot/productimages/colors/1_53908.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (38, 'Girl', 'Sanrio Gudetama', 'http://skateparkoftampa.com/spot/productimages/colors/1_73930.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (39, 'Girl', 'American Hero', 'http://cdn.shopify.com/s/files/1/0350/9069/products/DECK-GIRL-ONE-OFFS-MALTO-AMERICAN-HERO-8.12.jpg?v=1468195671');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (40, 'Girl', 'Positive Negative', 'https://d2qwzu24wcp0pu.cloudfront.net/skatehut/product/b1b7f3d.Girl%20Positive%20Negative%20Skateboard%20Deck%20-%20McCrank%208.375.jpg/1200x1200.fit.Girl%20Positive%20Negative%20Skateboard%20Deck%20-%20McCrank%208.375.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (41, 'Baker', 'Dee Hot Beans', 'http://www.easternskatesupply.com/Z/1DBAKOSTHBN81WR.png');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (42, 'Baker', 'Dee Gamer', 'http://www.easternskatesupply.com/Z/1DBAKOSTGMR80KA.png');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (43, 'Baker', 'Cyril Hot Weetos', 'http://socalskateshop.com/images/products/large_68633_Baker_cyril_cheetos_deck.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (44, 'Baker', 'Herman Theory', 'http://www.westsideskateshop.com/PDGImages/Baker%20Herman%20Theory-thumb.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (45, 'Baker', 'Figgy Posers', 'http://skateparkoftampa.com/spot/productimages/colors/1_74140.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (46, 'Baker', 'Reynolds Coffee Squad', 'http://skateparkoftampa.com/spot/productimages/colors/1_74141.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (47, 'Baker', 'Reynolds Cavolo', 'http://skatelyboardshop.com/img/shop/product/1/d/crop_rotate_170/1dbakreyrcv825a.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (48, 'Baker', 'Figgy Rekab', 'https://www.westsideskateshop.com/PDGImages/Baker%20Figgy%20Rekab%20Blue.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (49, 'Baker', 'dee', 'http://scene7.zumiez.com/is/image/zumiez/pdp_hero/Baker-Dee-Hot-Sauce-8.25%26quot%3B--Skateboard-Deck-_256287.jpg');
INSERT INTO `decks` (`iddecks`, `decks_brand`, `decks_name`, `urls`) VALUES (50, 'Baker', 'Theotis', 'http://www.skateparkoftampa.com/spot/productimages/colors/1_56464.jpg');

COMMIT;

