# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 04.02.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 08:45 | Riunione tra i componenti del gruppo                                |Tutti                       |
|08:45 - 09:05 | Ricerca e inizio bozza di programma per immagini                    |Michea                      |
|08:45 - 09:30 | Correzione errori nel programma di Guida del drone                  |Alessandro e Gianni         |
|09:05 - 09:30 | Creazione frecce per interfaccia grafica                            |Michea                      |
|09:30 - 09:50 | Test di volo con il drone + previsione per correzione errori        |Tutti                       |
|10:50 - 10:15 | Riunione con i docenti + punto della situazione                     |Tutti                       |
|10:15 - 11:00 | Test di volo con il drone + correzione errori                       |Alessandro e Gianni         |
|10:15 - 11:10 | Classe per la disposizione delle immagini (da sistemare)            |Michea                      |
|10:40 - 11:35 | Prove integrazione Leap Motion con Drone                            |Samuele                     |
|11:00 - 11:35 | Prove di volo con l'interfaccia grafica basata sul piano cartesiano |Gianni                      | 
|11:00 - 11:35 | Realizzazione live stream del drone                                 |Alessandro                  |
|11:10 - 11:35 | Scrittura diario di lavoro                                          |Michea                      |
|12:30 - 12:45 | Riunione per ricapitolare la situazione                             |Tutti                       |
|12:45 - 13:45 | Scrittura diario di lavoro                                          |Michea                      |
|12:45 - 15:45 | Live Stream da Drone                                                |Alessandro                  |
|12:45 - 13:15 | Conversione da GUI a controlli con tasi                             |Gianni                      |
|12:45 - 13:15 | Prove di connessione tra drone e Leap Motion                        |Samuele                     |
|13:15 - 15:45 | Prove di volo con Leap Motion                                       |Samuele e Gianni (fino a 14)|
|13:45 - 14:00 | Sistemate le immagini del drone e delle frecce, rese trasparenti    |Michea                      |
|14:00 - 14:45 | Risoluzione problema con conversione da GUI a input tastiera        |Gianni e Michea             |
|14:45 - 15:45 | Test di volo con input da tastiera + calibrazione                   |Gianni                      |



## Problemi riscontrati e soluzioni adottate
1. Nel nostro programma c'era ancora un errore di comunicazione, che non ci permetteva di comunicare con il "simulatore del drone". Abbiamo scoperto che l'antivirus su uno dei nostri PC bloccava la connessione. Quindi, sfruttando il fatto che Samuele era riuscito a procurare delle batterie compatibili con il nostro drone, abbiamo saltato lo step finale della simulazione, per passare alla pratica. Abbiamo quindi connesso il drone e provato a farlo decollare.

2. Dopo alcuni test abbiamo identificato dei problemi nel volo del drone: Primo fra tutti alcuni comandi del drone erano errati, e portavano a compiere manovre sbagliate. per esempio il drone virava sempre a sinistra, anche se l'istruzione che gli davamo era di andare a destra.
Abbiamo dovuto rileggere il codice e confrontarla con l'`SDK` trovata, per risolvere i problemi.

3. Dopo una riunione con i docenti sono emerse alcune problematiche: Il nostro sistema di guida era eccessivamente "rigido", infatti con la nostra GUI composta da bottoni potevamo inserire istruzioni singole, e mai combinate. Questo non si addice affatto al sistema di guida di un drone, dove le istruzioni sono spesso combinate (es avanti + destra). Quindi abbiamo dovuto modificare il sistema di pilotaggio, come prima cosa abbiamo virato su un sistema di pilotaggio su piano cartesiano, e non più su coordinate fisse. Questo ci ha permesso di avere movimenti molto più dolci e accurati rispetto a prima.

4. Il nuovo sistema di pilotaggio necessitava però di un interfaccia di guida nuova e migliorata, abbiamo inizialmente optato per un `text box` per l'inserimento di coordinate, poi abbiamo cambiato idea, utilizzando le frecce direzionali del computer per il pilotaggio.

5. Abbiamo anche notato che avere delle frecce sempre fisse, non è ottimale come idea, quindi al posto che usare delle frecce sempre fisse, con cui rappresentare più movimenti in contemporanea sarebbe difficile, dovremmo ideare una nuova strategia. Tuttavia per ora proseguiremo con questa strada, anche solo per avere un punto di partenza.

6. Nello sviluppo della live ci siamo accorti che non sarebbe stato così semplice gestire il flusso di dati della live, infatti dovevamo instaurare una connessione su un `socket`, e gestire questa con la connessione `socket` già aperta per il drone è piuttosto complesso. Il problema era il seguente. Se provavamo a collegare due classi con un `socket`, facendo finta che una fosse il PC e la seconda fosse il drone, la connessione veniva stabilita. Tuttavia tentando la connessione con il drone, cambiando indirizzo e porta (11111), come indicato sull'`SDK`, il drone non si connetteva.

7. Durante la connessione tra drone e `Leap Motion` abbiamo riscontrato dei problemi, il drone e il `Leap Motion` non si parlavano in alcun modo. Abbiamo svolto molti test, la maggior parte alla presenza di tutti. Gianni ha interrotto il suo lavoro per aiutare Samuele e venire a capo del problema più velocemente.
Dopo l'aiuto di Gianni e una progressione step by step (abbiamo testato ogni metodo singolarmente, procedendo dal `Leap Motion` verso la connessione con il drone in maniera sequenziale, abbiamo isolato il problema nei metodi di guida implementati con il `Leap Motion`. Abbiamo modificato quelli e si è risolto tutto.

8. Durante la conversione da input tramite pulsanti a input tramite frecce direzionali da tastiera, abbiamo rincontrato un problema piuttosto grosso. Pur implementando il `KeyListener` in maniera corretta, esso non comunicava con il nostro `panel`. Dopo molte ricerche abbiamo scoperto che `KeyListener` deve per forza essere associato a un entità di tipo `TextArea`. Fortunatamente disponevamo già di una cosa simile, in quanto abbiamo utilizzato una `TextArea` per il controllo del drone tramite coordinate. Di conseguenza nel costruttore di `BottoniPanel` abbiamo aggiunto la seguente istruzione, e ha finalmente funzionato

9. Sia con il `Leap Motion`, che tramite gli input da tastiera, spesso il drone era come sbilanciato, per questo abbiamo deciso di fare alcuni test di volo e calibrarlo man mano.


```java
public BottoniPanel() {
	...
	coordinateTB.addKeyListener(this); //cooridnateTB è la TextArea
}  
```   
Ecco quindi le soluzioni riassunte:


> 1. Identificazione problema nell'antivirus e connessione con il drone direttamente.
> 2. Rilettura del codice e test di volo.
> 3. Cambio del sistema di pilotaggio e navigazione.
> 4. Introduzione delle frecce come sistema di guida.
> 5. Colloquio con il docente.
> 6. Procedura step by step e insolazione problemi.
> 7. Ricerca online e test su esempi.
> 8. Calibrazione drone


##  Punto della situazione rispetto alla pianificazione
Siamo in tempo, benché sia necessario aggiornare il GANTT
## Programma di massima per la prossima giornata di lavoro
1. Sistemare i programmi che abbiamo creato oggi.
2. Mettere in comunicazione il drone con il pc, nell'ambito della trasmissione streaming.
3. Calibrare bene il drone e il suo sistema di guida.
4. Abbozzare a progettare o creare un interfaccia web
