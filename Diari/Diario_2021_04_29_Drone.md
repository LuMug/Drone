# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 29.04.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                                                       |Eseguito da          |
|--------------|----------------------------------------------------------------------------------------------------|---------------------|
|08:20 - 08:45 |Riunione generale                                                                                   |Tutti                |
|08:45 - 09:50 |Aggiornamento GANTT                                                                                 |Samuele              |
|08:45 - 11:35 |Live Stream drone                                                                                   |Alessandro e Gianni  |
|08:45 - 09:20 |Riscrittura ImageFrame (pannello PanelAlt)                                                          |Michea               |
|10:05 - 11:35 |Scrittura e correzione dei commenti delle classi + correzione e pulizia codice                      |Samuele              |
|09:20 - 11:35 |Scrittura Documentazione (1.5 capitoli)                                                             |Michea               |
|12:30 - 13:15 |Scrittura Documentazione (1 capitolo)                                                               |Michea               |
|12:30 - 14:15 |Live Stream                                                                                         |Gianni e Alessandro  |
|12:30 - 14:00 |Fix dell'esecuzione delle sequenze di comandi registrati                                            |Samuele              |
|13:15 - 13:45 |Assistenza live Stream                                                                              |Michea               |
|13:45 - 14:00 |Correzione Documentazione                                                                           |Michea               |
|14:15 - 15:45 |Fix sicurezza codice + correzione errori/supporto per spostamento `Frame` ImageFrame in Package drone |Samuele e Michea     |
|14:15 - 15:45 |Live Stream in Python                                                                               |Alessandro           |

######NB: Gianni partito a 15:00


## Problemi riscontrati e soluzioni adottate


1. Come per le lezioni precedenti, il nostro problema principale è stato la live stream: Il nostro primo tentativo si è focalizzato sull'uso di VLC. Tuttavia anche instaurando la comunicazione correttamente, lo stream non veniva aperta (Come le altre volte d’altronde). Siccome non riuscivamo in alcun modo a far funzionare la live, il professore ci ha consigliato di cercare su internet codici già pronti ed utilizzare quelli. Abbiamo quindi cercato diverse soluzioni, ma nulla di esse pareva funzionare. Finalmente nel pomeriggio abbiamo trovato un codice che faceva al caso nostro. Si basa su un codice `NodeJs`. Tramite una repository di GitHub ed `npm` si poteva aprire una comunicazione via web. Andando a `localhost:3000/index.html`, oppure `localhost:3001/stream` se fossero stati restituiti degli errori, si sarebbe potuto vedere quello che la videocamera del drone inviava.
2. Eliminato il problema live, è sorto un altro problema. Ora nella nostra interfaccia, dove doveva posizionarsi la live, c'era un buco che non poteva essere lasciato vuoto. Perciò abbiamo pensato di trasferire la vista del drone fornitaci da `ImageFrame` nel `Frame` principale dell'applicazione. 
Per farlo abbiamo dovuto trasformare il `Frame` in un `Panel`, per poi spostare i riferimenti che permettevano di far partire la `Thread` dal pulsante "Vista Drone", al costruttore di `DroneFrame`.
3. Mentre cercavamo di implementare i flip, si sono presentati alcuni problemi di interferenza. Infatti abbiamo capito che se qualcuno fa utilizzo della tastiera mentre il drone vola grazie al `Leap Motion`, esso inizia a muoversi in maniera scattosa e precipitare. Per questo abbiamo pensato di ignorare i comandi di una fonte se l'altra è attiva, ma non abbiamo ancora posto rimedio in maniera effettiva.
4. Il drone, a seguito di una caduta, non decollava più. Per questo abbiamo dovuto ri-calibrare l'`IMU` dall'applicazione mobile. Per poi cambiare posizione alle elice che, dopo essere state inavvertitamente montate al contrario, non permettevano al drone di alzarsi.
5. Dopo aver trasferito il `Frame` della vista del drone nel package `DronePK`, veniva restituito un `IndexOutOfBoundsException`. Tuttavia il problema si presentava solo su Windows. Su Mac invece no. Per questo dobbiamo indagare sul perché di questo bug.
6. Sempre per la live, una volta accertato il fatto che avremmo usato il codice in `NodeJs`, abbiamo dovuto fronteggiare il problema di come trasferire il flusso video dalla pagina `Localhost` al Java. Tuttavia i docenti ci hanno sconsigliato fortemente questo procedimento, in quanto anche librerie vecchie come `Spring` sono costruite per fare l'opposto di questo procedimento. Quindi abbiamo concluso che il bottone che avrebbe dovuto portarci alla vista del drone sarà invece il bottone che permetterà di aprire la pagina `Localhost`.
7. Nel `ComandiPanel` era presente un bottone inutile, chiamato "STATITISCHE". Inutile perché tutti i dati che il drone fornisce sono già presenti o nel `Frame` principale oppure in `ImageFrame` (ora nel `Frame` principale anche lui). Per questo lo abbiamo rimosso.

Ecco quindi le soluzioni riassunte:

>1. Utilizzo del codice trovato online: [Qui il riferimento](https://www.youtube.com/watch?v=OOA-D9i0q8U)
>2. Trasferimento di `ImageFrame`.
>3. Reset `IMU` + riposizionamento eliche.
>4. Rimozione bottone.
>5. Collegamento di un bottone ad una pagina in locale.




## Punto della situazione rispetto alla pianificazione
Oggi siamo finalmente riusciti a sistemare la live, che ora funziona.
Quindi siamo in tempo con i nostri programmi. 

## Programma di massima per la prossima giornata di lavoro
Nel corso della prossima lezione ci occuperemo di sistemare le ultime cose nel codice e poi 
potremmo dedicarci intensivamente alla documentazione e alla presentazione.
