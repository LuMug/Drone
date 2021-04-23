# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 22.04.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                                              |Eseguito da          |
|--------------|-------------------------------------------------------------------------------------------|---------------------|
|08:20 - 08:30 |Riunione componenti gruppo                                                                 |Tutti (no Michea)    |
|08:30 - 09:00 |Aggiornato GANTT e Trello                                                                  |Samuele              |    
|08:30 - 12:30 |Implementazione Live stream con VLC e altri software                                       |Alessandro e Gianni  |                      
|09:00 - 09:50 |Miglioramento codice da tastiera                                                           |Samuele              |
|09:50 - 11:35 |Scrittura  e correzione della documentazione                                               |Michea               |
|09:50 - 11:35 |Miglioramento codice e implementazione di tutti i tasti della tastiera                     |Samuele              |
|12:30 - 14:00 |Scrittura commenti del codice (Package drone)                                              |Alessandro           |
|12:30 - 14:00 |Miglioramento del codice ed implementazione dei flip                                       |Samuele              |
|12:30 - 14:00 |Implementazione Live Stream                                                                |Gianni               |
|12:30 - 14:00 |Scrittura documentazione e modifiche a ImageFrame                                          |Michea               |
|14:15 - 14:45 |Riunione con professore                                                                     |Tutti                |
|14:45 - 15:45 |Implementazione Live Stream                                                                |Gianni e Alessandro  |
|14:45 - 15:45 |Implementazione corretta del KeyListener nel frame e fix focus per l'ascolto dei pulsanti  |Samuele e Michea     |

######NB: Michea arrivato a 10:05.


## Problemi riscontrati e soluzioni adottate

1. Il primo problema all'ordine del giorno è stata la live, infatti nonostante i nostri tentativi continuava a non funzionare: Il primo tentativo è stato quello di usare VLC come programma per ricevere il flusso di dati tramite UDP. In linea teoria VLC si sarebbe dovuto occupare di convertire il flusso in arrivo dal drone, che arrivava, poiché anche provando a stampare i dati in arrivo con il nostro programma, veniva stampata una lunga stringa di byte. 
Tuttavia VLC non riusciva a decodificare/interpretare/mostrare il video. Per escludere dei problemi di comunicazione o di antivirus (in passato avevamo avuto problemi così), abbiamo disattivato tutti i blocchi e abbiamo fatto un test di trasmissione video UDP da un pc a un altro, che sono andati a buon fine.
2. Abbiamo anche provato a usare tool diversi rispetto a VLC: Michea ha provato con `FFmpeg`, ma anche in questo caso la connessione veniva accettata, i dati trasmessi, ma non c'era modo di convertire il segnale in arrivo in un video.
3. Il controllo del drone da tastiera era ancora in fase embrionale, infatti il drone eseguiva le istruzioni con una certa lentezza e non fluidità; per questo abbiamo limitato le istruzioni che vengono inviate, ma anche adattato i movimenti e la sensibilità in base alla velocità selezionata. 
4. Sempre nell'ambito del controllo del drone usando la tastiera, se fosse stata aperta la finestra con le immagini del drone, i comandi non avrebbero risposto più. Per ovviare a questo problema abbiamo dovuto implementare `MouseListener`; ora quando viene chiamato un `MouseClicked`, viene eseguito questo codice: 


```java
@Override
    public boolean isFocusTraversable() {
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isFocusTraversable();
        this.requestFocus();
    }
```
Il metodo `isFocusTraversable`, permette di settare il Focus. Mentre `this.requestFocus` è un metodo interno a `JFrame`: è un modo ulteriore per richiedere il focus sul frame corrente.



## Punto della situazione rispetto alla pianificazione

Abbiamo recuperato molto rispetto alla scorsa lezione, quindi siamo in tempo.

## Programma di massima per la prossima giornata di lavoro
1. ***MOLTO IMPORTANTE*** riuscire a procedere con la Live
2. Procedere con la documentazione
