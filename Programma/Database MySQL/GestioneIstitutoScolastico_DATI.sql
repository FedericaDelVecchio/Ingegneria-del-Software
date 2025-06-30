INSERT INTO `GestioneIstitutoScolastico`.`Presidi` (`username`, `password`)
VALUES ('preside1', 'password123');

INSERT INTO `GestioneIstitutoScolastico`.`Classi` (`anno`, `sezione`, `Presidi_username`)
VALUES ('I', 'A', 'preside1');

INSERT INTO `GestioneIstitutoScolastico`.`Classi` (`anno`, `sezione`, `Presidi_username`)
VALUES ('II', 'B', 'preside1');

INSERT INTO `GestioneIstitutoScolastico`.`Classi` (`anno`, `sezione`, `Presidi_username`)
VALUES ('III', 'C', 'preside1');

INSERT INTO `GestioneIstitutoScolastico`.`Classi` (`anno`, `sezione`, `Presidi_username`)
VALUES ('IV', 'D', 'preside1');

INSERT INTO `GestioneIstitutoScolastico`.`Classi` (`anno`, `sezione`, `Presidi_username`)
VALUES ('V', 'E', 'preside1');



INSERT INTO `GestioneIstitutoScolastico`.`Alunni` (`username`, `password`, `nome`, `cognome`, `nascita`, `residenza`, `cellulare`, `codiceFiscale`, `email`, `matricola`, `Classi_anno`, `Classi_sezione`)
VALUES ('alunno1', 'password123', 'Mario', 'Rossi', '10/05/1999', 'Napoli', '123456789', 'RSSMRA99A10H501X', 'mario.rossi@example.com', '12345', 'III', 'C'),
('alunno2', 'securepass456', 'Luca', 'Verdi', '15/07/2000', 'Salerno', '987654321', 'VRDLCA00B15F502Y', 'luca.verdi@example.com', '67890', 'IV', 'D'),
('alunno3', 'password789', 'Giulia', 'Bianchi', '25/01/2001', 'Caserta', '456123789', 'BNCGLI01A25G503Z', 'giulia.bianchi@example.com', '54321', 'II', 'B'),
('alunno4', 'abc123', 'Paola', 'Ferrari', '02/03/2002', 'Napoli', '789456123', 'FRRPLA02C02I504W', 'paola.ferrari@example.com', '98765', 'I', 'A'),
('alunno5', 'pass456', 'Marco', 'Russo', '18/09/2003', 'Salerno', '654123987', 'RSSMRC03P18E501V', 'marco.russo@example.com', '54321', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Alunni` (`username`, `password`, `nome`, `cognome`, `nascita`, `residenza`, `cellulare`, `codiceFiscale`, `email`, `matricola`, `Classi_anno`, `Classi_sezione`)
VALUES ('alunno6', 'newpassword789', 'Giuseppe', 'Verdi', '03/12/2004', 'Roma', '123456789', 'VRDGPP04A03R501Z', 'giuseppe.verdi@example.com', '13579', 'III', 'C'),
('alunno7', 'securepass123', 'Francesca', 'Russo', '05/06/2005', 'Milano', '987654321', 'RSSFNC05H05M502W', 'francesca.russo@example.com', '24680', 'IV', 'D'),
('alunno8', 'passwordabc', 'Antonio', 'Bianchi', '10/02/2006', 'Firenze', '456123789', 'BNCTON06A10F503X', 'antonio.bianchi@example.com', '97531', 'II', 'B'),
('alunno9', 'mypass123', 'Giorgio', 'Ferrari', '15/07/2007', 'Torino', '789456123', 'FRRGIO07L15T504U', 'giorgio.ferrari@example.com', '86420', 'I', 'A'),
('alunno10', 'pass123456', 'Laura', 'Gialli', '20/11/2008', 'Napoli', '654123987', 'GLLLRA08T20N501R', 'laura.gialli@example.com', '75309', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Alunni` (`username`, `password`, `nome`, `cognome`, `nascita`, `residenza`, `cellulare`, `codiceFiscale`, `email`, `matricola`, `Classi_anno`, `Classi_sezione`)
VALUES ('alunno11', 'mysecretpass', 'Alessia', 'Martini', '28/04/2009', 'Bologna', '123456789', 'MRTLSA09D28B501A', 'alessia.martini@example.com', '56789', 'III', 'C'),
('alunno12', 'password987', 'Simone', 'Romano', '07/09/2010', 'Genova', '987654321', 'RMNSMN10P07G502B', 'simone.romano@example.com', '98765', 'IV', 'D'),
('alunno13', 'securepass321', 'Valentina', 'Conti', '13/01/2011', 'Torino', '456123789', 'CNTVLT11A13T503C', 'valentina.conti@example.com', '43210', 'II', 'B'),
('alunno14', 'abc123xyz', 'Giovanni', 'Marini', '20/06/2012', 'Firenze', '789456123', 'MRNGVN12H20F504D', 'giovanni.marini@example.com', '54321', 'I', 'A'),
('alunno15', 'pass789xyz', 'Elena', 'Costa', '25/11/2013', 'Milano', '654123987', 'CSTELN13T25M501E', 'elena.costa@example.com', '98765', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Alunni` (`username`, `password`, `nome`, `cognome`, `nascita`, `residenza`, `cellulare`, `codiceFiscale`, `email`, `matricola`, `Classi_anno`, `Classi_sezione`)
VALUES ('alunno16', 'password456', 'Roberto', 'Galli', '08/03/2014', 'Roma', '123456789', 'GLLRBT14C08R501F', 'roberto.galli@example.com', '75391', 'III', 'C'),
('alunno17', 'securepass789', 'Federica', 'Santoro', '15/08/2015', 'Napoli', '987654321', 'SNTRFC15M15N502G', 'federica.santoro@example.com', '24680', 'IV', 'D'),
('alunno18', 'pass123abc', 'Anna', 'Rinaldi', '20/01/2016', 'Milano', '456123789', 'RNLANA16A20M503H', 'anna.rinaldi@example.com', '86420', 'II', 'B'),
('alunno19', 'mypassword', 'Davide', 'Guerini', '25/06/2017', 'Bergamo', '789456123', 'GRNDVD17H25B504I', 'davide.guerini@example.com', '97531', 'I', 'A'),
('alunno20', 'pass789abc', 'Valeria', 'Ferrari', '30/11/2018', 'Torino', '654123987', 'FRRVLR18T30T501J', 'valeria.ferrari@example.com', '75309', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Alunni` (`username`, `password`, `nome`, `cognome`, `nascita`, `residenza`, `cellulare`, `codiceFiscale`, `email`, `matricola`, `Classi_anno`, `Classi_sezione`)
VALUES ('alunno21', 'securepass123', 'Chiara', 'Lombardi', '03/04/2019', 'Firenze', '123456789', 'LMBCHR19D03F501D', 'chiara.lombardi@example.com', '56789', 'III', 'C'),
('alunno22', 'password987', 'Simone', 'Galli', '10/09/2020', 'Bologna', '987654321', 'GLLSMN20P10B502E', 'simone.galli@example.com', '98765', 'IV', 'D'),
('alunno23', 'abc123xyz', 'Martina', 'Rossi', '15/01/2021', 'Milano', '456123789', 'RSSMRT21A15M503F', 'martina.rossi@example.com', '43210', 'II', 'B'),
('alunno24', 'pass123456', 'Luigi', 'Ricci', '22/06/2022', 'Roma', '789456123', 'RCCGLU22H22R504G', 'luigi.ricci@example.com', '54321', 'I', 'A'),
('alunno25', 'pass789xyz', 'Sara', 'Conte', '27/11/2023', 'Napoli', '654123987', 'CNTSRA23T27N501I', 'sara.conte@example.com', '98765', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori` (`username`, `password`, `nome`, `cognome`, `residenza`, `cellulare`, `codiceFiscale`, `email`)
VALUES
  ('genitore1', 'password123', 'Maria', 'Rossi', 'Napoli', '987654321', 'RSSMRA99A10H501X', 'maria.rossi@example.com'),
  ('genitore2', 'securepass456', 'Giovanni', 'Verdi', 'Salerno', '123456789', 'VRDLCA00B15F502Y', 'giovanni.verdi@example.com'),
  ('genitore3', 'password789', 'Laura', 'Bianchi', 'Caserta', '456123789', 'BNCGLI01A25G503Z', 'laura.bianchi@example.com'),
  ('genitore4', 'abc123', 'Luigi', 'Ferrari', 'Napoli', '789456123', 'FRRPLA02C02I504W', 'luigi.ferrari@example.com'),
  ('genitore5', 'pass456', 'Anna', 'Russo', 'Salerno', '654123987', 'RSSMRC03P18E501V', 'anna.russo@example.com'),
  ('genitore6', 'password789', 'Marco', 'Bianchi', 'Roma', '789123456', 'BNCMRC04D01G504Z', 'marco.bianchi@example.com');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori` (`username`, `password`, `nome`, `cognome`, `residenza`, `cellulare`, `codiceFiscale`, `email`)
VALUES
  ('genitore7', 'newpassword789', 'Giuseppe', 'Rossi', 'Milano', '987654321', 'RSSGPP99A10M501X', 'giuseppe.rossi@example.com'),
  ('genitore8', 'securepass123', 'Francesca', 'Verdi', 'Firenze', '123456789', 'VRDFNC00B15F502Y', 'francesca.verdi@example.com'),
  ('genitore9', 'password987', 'Simona', 'Bianchi', 'Napoli', '456123789', 'BNCBNA01A25G503Z', 'simona.bianchi@example.com'),
  ('genitore10', 'abc123xyz', 'Paolo', 'Ferrari', 'Roma', '789456123', 'FRRPLA02C02I504W', 'paolo.ferrari@example.com'),
  ('genitore11', 'pass123456', 'Elena', 'Russo', 'Salerno', '654123987', 'RSSERU03P18E501V', 'elena.russo@example.com'),
  ('genitore12', 'pass789abc', 'Marco', 'Bianchi', 'Torino', '789123456', 'BNCMRC04D01G504Z', 'marco.bianchi@example.com');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori` (`username`, `password`, `nome`, `cognome`, `residenza`, `cellulare`, `codiceFiscale`, `email`)
VALUES
  ('genitore13', 'mypassword123', 'Roberta', 'Martini', 'Bologna', '123456789', 'MRTBRB99A10B501X', 'roberta.martini@example.com'),
  ('genitore14', 'pass987654', 'Giacomo', 'Romano', 'Genova', '987654321', 'RMNGCM00B15G502Y', 'giacomo.romano@example.com'),
  ('genitore15', 'abc123xyz', 'Martina', 'Conti', 'Milano', '456123789', 'CNTMTN01A25M503Z', 'martina.conti@example.com'),
  ('genitore16', 'password123456', 'Luigi', 'Ferrari', 'Napoli', '789456123', 'FRRGLI02C02N504W', 'luigi.ferrari@example.com'),
  ('genitore17', 'securepass789', 'Elena', 'Russo', 'Salerno', '654123987', 'RSSERU03P18E501V', 'elena.russo@example.com'),
  ('genitore18', 'pass789abc', 'Marco', 'Bianchi', 'Roma', '789123456', 'BNCMRC04D01G504Z', 'marco.bianchi@example.com');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore1', 'alunno1'), ('genitore2', 'alunno1');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore3', 'alunno2');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore4', 'alunno3'), ('genitore5', 'alunno3');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore6', 'alunno5');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore7', 'alunno6'), ('genitore8', 'alunno6');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore9', 'alunno7'), ('genitore10', 'alunno7');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore11', 'alunno8');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore12', 'alunno9'), ('genitore13', 'alunno9');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore14', 'alunno10');

INSERT INTO `GestioneIstitutoScolastico`.`Genitori_has_Alunni` (`Genitori_username`, `Alunni_username`)
VALUES ('genitore15', 'alunno11'), ('genitore16', 'alunno11');


INSERT INTO `GestioneIstitutoScolastico`.`Docenti` (`username`, `password`, `nome`, `cognome`, `residenza`, `cellulare`, `codiceFiscale`, `email`)
VALUES
  ('docente1', 'password123', 'Paolo', 'Gialli', 'Napoli', '987654321', 'GLLPLA99A10H501X', 'paolo.gialli@example.com'),
  ('docente2', 'securepass456', 'Simona', 'Rossi', 'Salerno', '123456789', 'RSSSMN00B15F502Y', 'simona.rossi@example.com'),
  ('docente3', 'password789', 'Marco', 'Verdi', 'Caserta', '456123789', 'VRDMRC01A25G503Z', 'marco.verdi@example.com'),
  ('docente4', 'abc123', 'Laura', 'Bianchi', 'Napoli', '789456123', 'BNCPLA02C02I504W', 'laura.bianchi@example.com'),
  ('docente5', 'pass456', 'Giovanni', 'Russo', 'Salerno', '654123987', 'RSSGNN03P18E501V', 'giovanni.russo@example.com');
  
  INSERT INTO `GestioneIstitutoScolastico`.`Docenti` (`username`, `password`, `nome`, `cognome`, `residenza`, `cellulare`, `codiceFiscale`, `email`)
VALUES ('docente6', 'password987', 'Luca', 'Ferrari', 'Roma', '987654321', 'FRRLCU99A10H501X', 'luca.ferrari@example.com'),
       ('docente7', 'securepass123', 'Valentina', 'Gallo', 'Milano', '123456789', 'GLLVNT00B15F502Y', 'valentina.gallo@example.com'),
       ('docente8', 'pass789', 'Fabio', 'Bianco', 'Firenze', '456123789', 'BNCFBF01A25G503Z', 'fabio.bianco@example.com'),
       ('docente9', 'abc456', 'Giulia', 'Rusconi', 'Torino', '789456123', 'RSCGLI02C02I504W', 'giulia.rusconi@example.com'),
       ('docente10', 'password123', 'Roberto', 'Marini', 'Napoli', '654123987', 'MRNRBT03P18E501V', 'roberto.marini@example.com');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente2', 'I', 'A', 'Italiano');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente3', 'II', 'B', 'Storia');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente4', 'III', 'C', 'Scienze');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente5', 'IV', 'D', 'Inglese');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente6', 'V', 'E', 'Arte');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente1', 'I', 'A', 'Matematica');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente1', 'I', 'A', 'Scienze');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente2', 'II', 'B', 'Italiano');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente4', 'III', 'C', 'Inglese');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente4', 'III', 'C', 'Arte');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente6', 'I', 'A', 'Arte');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente7', 'II', 'B', 'Musica');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente8', 'III', 'C', 'Educazione Fisica');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente9', 'IV', 'D', 'Geografia');

INSERT INTO `GestioneIstitutoScolastico`.`docenti_has_classi` (`Docenti_username`, `Classi_anno`, `Classi_sezione`, `materia`)
VALUES ('docente10', 'V', 'E', 'Tecnologia');



INSERT INTO `GestioneIstitutoScolastico`.`RegistriElettronici` (`annoScolastico`, `Classi_anno`, `Classi_sezione`)
SELECT '2022/2023', `anno`, `sezione`
FROM `GestioneIstitutoScolastico`.`Classi`
WHERE `anno` = 'I' AND `sezione` = 'A';

INSERT INTO `GestioneIstitutoScolastico`.`RegistriElettronici` (`annoScolastico`, `Classi_anno`, `Classi_sezione`)
SELECT '2022/2023', `anno`, `sezione`
FROM `GestioneIstitutoScolastico`.`Classi`
WHERE `anno` = 'II' AND `sezione` = 'B';

INSERT INTO `GestioneIstitutoScolastico`.`RegistriElettronici` (`annoScolastico`, `Classi_anno`, `Classi_sezione`)
SELECT '2022/2023', `anno`, `sezione`
FROM `GestioneIstitutoScolastico`.`Classi`
WHERE `anno` = 'III' AND `sezione` = 'C';

INSERT INTO `GestioneIstitutoScolastico`.`RegistriElettronici` (`annoScolastico`, `Classi_anno`, `Classi_sezione`)
SELECT '2022/2023', `anno`, `sezione`
FROM `GestioneIstitutoScolastico`.`Classi`
WHERE `anno` = 'IV' AND `sezione` = 'D';

INSERT INTO `GestioneIstitutoScolastico`.`RegistriElettronici` (`annoScolastico`, `Classi_anno`, `Classi_sezione`)
SELECT '2022/2023', `anno`, `sezione`
FROM `GestioneIstitutoScolastico`.`Classi`
WHERE `anno` = 'V' AND `sezione` = 'E';



INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (1, 'Matematica', 'Esercizi sulle equazioni', '10/01/2023', 'III', 'C');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (2, 'Italiano', 'Analisi del testo', '15/02/2023', 'IV', 'D');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (3, 'Storia', 'Le guerre mondiali', '20/03/2022', 'I', 'A');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (4, 'Scienze', 'Esperimento sulle reazioni', '05/04/2022', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (5, 'Inglese', 'Conversazione su attualità', '10/05/2022', 'III', 'C');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (6, 'Matematica', 'Risoluzione di equazioni', '15/06/2022', 'IV', 'D');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (7, 'Italiano', 'Analisi del Il Gattopardo"', '25/07/2022', 'V', 'E');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (8, 'Arte', 'Realizzazione di un dipinto', '10/09/2022', 'I', 'A');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (9, 'Matematica', 'Esercizi sulle frazioni', '10/02/2023', 'I', 'A');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (10, 'Italiano', 'Lettura e analisi di un romanzo', '15/02/2023', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (11, 'Storia', 'La Rivoluzione Francese', '20/02/2023', 'III', 'C');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (12, 'Scienze', 'Esperimento sull elettricita', '25/02/2023', 'IV', 'D');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (13, 'Inglese', 'Vocabolario e dialoghi', '01/03/2023', 'V', 'E');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (14, 'Arte', 'Creazione di un acquerello', '05/03/2023', 'I', 'A');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (15, 'Musica', 'Esecuzione di una canzone', '10/03/2023', 'II', 'B');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (16, 'Geografia', 'Studio delle capitali europee', '15/03/2023', 'III', 'C');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (17, 'Educazione Fisica', 'Partita di calcio', '20/03/2023', 'IV', 'D');

INSERT INTO `GestioneIstitutoScolastico`.`Attivita` (`idAttivita`, `materia`, `descrizione`, `data`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`)
VALUES (18, 'Informatica', 'Programmazione in Python', '25/03/2023', 'V', 'E');



INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (1, 8, '01/02/2022', 'Matematica', 'III', 'C', 'alunno1');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (2, 7, '02/02/2022', 'Italiano', 'IV', 'D', 'alunno2');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (3, 6, '03/02/2022', 'Storia', 'II', 'B', 'alunno3');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (4, 9, '04/02/2022', 'Scienze', 'I', 'A', 'alunno4');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (5, 8, '05/02/2022', 'Inglese', 'II', 'B', 'alunno5');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (6, 7, '10/02/2022', 'Geografia', 'III', 'C', 'alunno1');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (7, 8, '11/02/2022', 'Arte', 'IV', 'D', 'alunno2');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (8, 4, '03/06/2022', 'Matematica', 'III', 'C', 'alunno21');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (9, 5, '01/05/2023', 'Italiano', 'IV', 'D', 'alunno22');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (10, 3, '12/03/2022', 'Tecnologia', 'II', 'B', 'alunno23');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (11, 8, '09/08/2022', 'Tecnologia', 'II', 'B', 'alunno23');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (12, 10, '25/12/2023', 'Inglese', 'II', 'B', 'alunno25');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (13, 7, '19/04/2022', 'Geografia', 'III', 'C', 'alunno11');

INSERT INTO `GestioneIstitutoScolastico`.`Voti` (`idVoti`, `valore`, `data`, `materia`, `RegistriElettronici_Classi_anno`, `RegistriElettronici_Classi_sezione`, `Alunni_username`)
VALUES (14, 6, '13/02/2022', 'Arte', 'IV', 'D', 'alunno12');