
DELIMITER //
CREATE PROCEDURE EPrimo (numero INT)
BEGIN
DECLARE contador	 INT DEFAULT 0;
DECLARE divide INT DEFAULT 0;
DECLARE EPrimo INT DEFAULT 1;
 IF (numero <= 1) THEN
	SET EPrimo = 0;

    while (EPrimo = 1 && divide <= numero / 2) DO
	if (numero / divide  = 1) THEN
		SET EPrimo = 1;
	SET divide = divide + 1;
 END IF;
 end while;
END IF;

SELECT EPrimo;
END//
DELIMITER ;




DELIMITER //
CREATE PROCEDURE RetornaFatorial (numero INT)
BEGIN
DECLARE soma INT DEFAULT 0;
DECLARE fatorial INT DEFAULT 0;

    while (numero > 0) DO
	SET fatorial = numero * soma;  
	SET numero = numero - 1;
 end while;


SELECT fatorial;
END//
DELIMITER ;