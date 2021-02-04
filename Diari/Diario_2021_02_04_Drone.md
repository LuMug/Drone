# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 04.02.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                |
|--------------|---------------------------------------------------------------------|---------------------------|
|08:20 - 08:45 | Riunione tra i componenti del gruppo                                |Tutti                      |
|08:45 - 09:05 | Ricerca e inizio bozza di programma per immagini                    |Michea                     |
|08:45 - 09:30 | Correzione errori nel programma di Guida del drone                  |Alessandro e Gianni        |
|09:05 - 09:30 | Creazione frecce per interfaccia grafica                            |Michea                     |
|09:30 - 09:50 | Test di volo con il drone + previsione per correzione errori        |Tutti                      |
|10:50 - 10:15 | Riunione con i docenti + punto della situazione                     |Tutti                      |
|10:15 - 11:00 | Test di volo con il drone + correzione errori                       |Alessandro e Gianni        |
|10:15 - 11:10 | Classe per la disposizione delle immagini (da sistemare)            |Michea                     |
|10:40 - 11:35 | Prove integrazione Leap Motion con Drone                            |Samuele                    |
|11:00 - 11:35 | Prove di volo con l'interfaccia grafica basata sul piano cartesiano |Gianni                     |
|11:00 - 11:35 | Realizzazzione live stream del drone                                |Alessandro                 |
|11:10 - 11:35 | Scrittura diario di lavoro                                          |Michea                     |
|12:30 - 12:45 | Riunione per ricapitolare la situazione                             |Tutti                      |
|12:45 - 13:45 | Scrittura diario di lavoro                                          |Michea                     |
|12:45 - ??:?? | Live Stream da Drone                                                |Alessandro                 |
|12:45 - 13:15 | Conversione da GUI a controlli con tasi                             |Gianni                     |
|12:45 - 13:15 | Prove di connessione tra drone e leap motion                        |Samuele                    |
|13:15 - ??:?? | Prove di volo con leap motion                                       |Samuele e Gianni           |

## Problemi riscontrati e soluzioni adottate
1. Nel nostro programma c'era ancora un errore di comunicazione, che non ci permetteva di comunicare con il "simulatore del drone". Abbiamo scoperto che l'antivrus su uno dei nostri PC bloccava la connessione. Quindi, sfruttando il fatto che Samuele era riusicto a procurare delle batterie compatibili con il nostro drone, abbiamo saltato lo step finale della simulazione, per passare alla pratica. Abbiamo quindi connesso il drone e provato a farlo decollare.

2. Dopo alcuni test abbiamo identifcato dei problmi nel volo del drone: Primo fra tutti alcuni comandi del drone erano errati, e portavano a compiere manovre sbagliate. per esempio il dorne virava sempre a sinistra, anche se l'istruzione che gli davamo era di andare a destra.
Abbiamo dovuto rileggere il codice e confronatrla con l'sdk torvata, per risolvere i problemi.

3. Dopo una riunione con i docenti sono emerse alcune problematiche: Il nostro sistema di guida era eccessivamente "rigido", infatti con la nostra GUI composta da bottoni potevamo inserire istruzioni singole, e mai combinate. Questo non si addice affatto al sistema di guida di un drone, dove le istruziomni sono spesso combinate (es avanti+a destra). Quindi abbiamo dovuto modificare il sistema di pilotaggio, come prima cosa abbiamo virato su un sistema di pilotaggio su piano cartesiano, e non più su coordinate fisse. Questo ci ha permesso di avere movimenti molto più dolci e accurati rispetto a prima.

4. Il nuovo sistema di pilotaggio necessitava però di un interfaccia di guida nuova e migliorata, abbiamo inizialmente optato per un `text box` per l'inserimento di coordinate, poi abbiamo cambiato idea, utilizzando le freccie direzionali del computer per il pilotaggio.

5. Abbiamo anche notato che avere delle frecce sempre fisse, non è ottimale come idea, quindi al posto che usare delle freccie sempre fisse, con cui rappresentare più moviemnti in contemporanea sarebbe difficile, dovremmo ideare una nuova strategia. Tuttavia per ora proseguiremo con questa strada,anche solo per avere un punto di partenza.

6. nello sviluppo della live ci siamo accorti che non sarebbe stato così semplice gestire il flusso di dati della live, infatti dovevamo instaurare una connessione su un socket, e gesitre questa con la connessione socket già aperta per il dorne è piuttosto complesso. Soluzione in elaborazione tramite consultazione con il docente.

7. Durante la connessione tra drone e leap motion abbiamo riscontrato dei problemi, il dorne e il leap motion non si parlavano in alucn modo. Abbiamo svolto molti test, la maggior parte alla presenza di tutti. Gianni ha interrotto il suo lavoro per aiutare samuele e venire a capo del problema più velocemente.


Ecco quindi le soluzioni riassunte:


> 1. Identificazione problema nell'antivirus e connessione con il drone direttamente.
> 2. Rilettura del codice e test di volo.
> 3. Cambio del sistema di pilotaggio e navigazione.
> 4. Introduzione delle freccie come sistema di guida.
> 5. Colloquio con il docente


##  Punto della situazione rispetto alla pianificazione

## Programma di massima per la prossima giornata di lavoro
