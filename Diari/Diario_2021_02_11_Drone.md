# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 11.02.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                        |Eseguito da                 |
|--------------|---------------------------------------------------------------------|----------------------------|
|08:20 - 08:45 | Riunione e attesa Samuele                                           |Tutti                       |
|08:45 - 09:40 | Aggiornamento sui problemi e ricerca soluzione                      |Tutti                       |
|09:00 - 09:40 | Aggiornamento Gantt consuntivo                                      |Samuele e Michea            |
|09:00 - 09:50 | Ricerca SDK drone di riserva                                        |Alessandro                  |
|09:00 - 09:50 | Revisione Trello e risoluzione errori minori nel codice             |Gianni                      |
|09:40 - 09:50 | Diario di lavoro                                                    |Michea e Samuele            |
|10:05 - 10:20 | Prove drone di riserva e ricerca connessione internet               |Tutti                       |
|10:20 - 10:50 | Riunione con Professore per il punto della situazione               |Tutti                       |
|10:50 - 11:00 | Discussione tra di noi                                              |Tutti                       |
|11:00 - 11:35 | Ricerca per Leap Motion                                             |Samuele                     |
|11:00 - 11:35 | Ricerca per socket e comunicazione                                  |Alessandro e Gianni         |
|11:00 - 11:35 | Ricerca per immagini in Java                                        |Michea                      |






## Problemi riscontrati e soluzioni adottate
1. Il problema principale della giornata è grave, non abbiamo la batteria per il drone dato che non è ancora arrivata, perciò abbiamo dovuto inventarci qualcosa. Per ora ci limiteremo a svolgere attività di tipo "burocratico", quindi aggiornare il Gantt, approvare lo schema di flusso e altri schemi, ecc. Probabilmente oggi pomeriggio avremo un drone di scorta, diverso dal `DJI Tello ` che abbiamo solitamente. Dovremo forse adattare un po' il codice, ma pensiamo che sia meglio impiegare un po' di tempo per quest'attività, in modo da procedere con tutti gli altri compiti

2. Dopo esserci consultati con il professore, aver eseguito ricerche e esserci documentati, abbiamo scoperto che l'idea di utilizzare il drone di riserva, un `DJI Mavic Mini 1` non avrebbe funzionato. Questo perché il drone non crea una rete Wi-Fi, e non comunica con pacchetti UDP. Perciò l'idea era da scartare.
A questo punto, con nessuna possibilità di far decollare alcun drone, abbiamo deciso di dare la precedenza a altri aspetti del codice, sistemare quello già presente, ed iniziare ad implementare ciò che manca.

3. Per l'implementazione, abbiamo usato un metodo che avevamo già adottato in passato, creare un simulatore del drone tramite un `socket`. Tuttavia questa volta sarebbe stato meglio, abbiamo riscritto il codice per la comunicazione, in questo modo il PC riusciva ad inviare dati, come le coordinate o i comandi `UP` `DOWN` al simulatore del drone. Esso, una volta stampati i dati e quindi aver dimostrato di averli letti correttamente, inviava dei dati in risposta. Questo passaggio ci servirà in futuro, quando dovremmo inviare dei dati come altezza, posizione, vento, ecc.
Non abbiamo la certezza matematica che il codice scritto oggi funzioni, ma abbiamo una solida base da cui riaprire.

4. Per quanto riguarda il `Leap Motion`, abbiamo pulito il codice già presente, eliminando per esempio i sistemi di log `(print)`. Inoltre abbiamo implementato la rotazione, ora il sensore è in grado di capire se la mano sta ruotando. Siccome c'era ancora del tempo, abbiamo ricercato alcune informazioni che ci torneranno utili nel nuovo sistema di guida, non fisso questa volta, ma dinamico.

5. Per quanto riguarda le immagini abbiamo essenzialmente dovuto ricominciare da capo: la soluzione adottata prima, usando un `Toolkit` per la gestione delle immagini non permetteva di eseguire istruzioni come la rotazione. Per questo abbiamo ripiegato sulle `Buffered Image`, molto più efficienti. Questo ci ha permesso di creare il frame che poi verrà inserito nelle statistiche del drone. Abbiamo dovuto prendere alcune precauzioni, infatti il girare le immagini esse venivano tagliate fuori dal frame.

Ecco quindi le soluzioni riassunte:


> 1. Idea per l'adattamento del codice per drone di scorta.
> 2. Procedimento con altri aspetti del codice.
> 3. Simulazione drone tramite `socket`.
> 4. Utilizzo di `BufferedImage`.


## Punto della situazione rispetto alla pianificazione
dato che avevamo un po' di vantaggio sulla nostra pianificazione, siamo ancora in tempo.


## Programma di massima per la prossima giornata di lavoro
Vorremmo principalmente testare il codice creato oggi, definire il sistema di guida tramite `Leap Motion` utilizzando le coordinate, e rendere il volo del drone molto più fluido rispetto a prima.

