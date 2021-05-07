# Drone | Diario di lavoro
##### Michea Colautti, Alessandro Aloise, Gianni Grasso, Samuele Ganci
### Centro Professionale Trevano, 06.05.2021

## Lavori svolti


|Orario        |Lavoro svolto                                                                                       |Eseguito da          |
|--------------|----------------------------------------------------------------------------------------------------|---------------------|
|08:20 - 08:30 |Riunione generale                                                                                   |Tutti                |
|08:30 - 08:50 |Riparate para eliche del drone                                                                      |Michea e Alessandro  |
|08:50 - 09:50 |Gestione resize di ImageFrame                                                                       |Michea               |
|08:50 - 09:15 |Tasto per link pagina                                                                               |Alessandro           |
|08:30 - 09:50 |Attivazione e disattivazione tastiera/Leap Motion in base a radio button                            |Ganci                |
|08:30 - 11:35 |Documentazione capitolo Implementazione                                                             |Gianni               |
|09:15 - 09:50 |Pulizia codice live + comprensione del codice NodeJs                                                |Alessandro           |
|10:05 - 10:35 |Fix live stream (incompatibilità tra Mac e Windows)                                                 |Michea               |
|10:05 - 10:35 |Script Live Windows                                                                                 |Alessandro           |
|10:05 - 11:35 |Implementato Listener per controllo da tastiera o da Leap                                           |Samuele              |
|10:35 - 11:35 |Correzione script bash per live Mac                                                                 |Michea e Alessandro  |
|12:30 - 15:45 |Documentazione + supporto                                                                           |Gianni               |
|12:30 - 14:00 |Emergency Landing                                                                                   |Ganci                |
|12:30 - 14:15 |Correzione script bash per live Mac                                                                 |Michea e Alessandro  |
|14:15 - 15:00 |Consultazione docente per script                                                                    |Michea e Alessandro  |
|14:15 - 15:45 |Pulizia codice e commenti + commit finale con merge progressi giornata                              |Samuele              |
|15:00 - 15:45 |Prove con Jar + tentativo di fix con docente                                                        |Michea e Alessandro  |


## Problemi riscontrati e soluzioni adottate
Ecco quindi le soluzioni riassunte:



1. I para eliche del drone erano rotti, in molti punti stavano quasi per staccarsi di netto. Per questo abbiamo deciso di riparare con della colla i para eliche, e di sostituire le eliche, anche esse rovinate dopo molte botte.
2. Ci siamo accorti, implementando il meccanismo di Emergency Landing, che il tasto prescelto (e), non avrebbe funzionato se il drone fosse stato in uso con il Leap. Questo perché l'uso con il Leap "disabilitava" gli input da tastiera. Per questo abbiamo dovuto implementare un listener serpato.
3. Nell'implementare la live, ci siamo accorti che su Windows funzionava correttamente, ma su Mac non c'era modo di farla funzionare. Abbiamo ri-gurdato molte volte il codice, ma inizialmente senza successo. Abbiamo pensato a un problema di concorrenza con il programma per guidarlo, ma dopo numerosi tentavi e aggiustamenti nel codice, abbiamo pensato che forse il drone fosse troppo scarico per decollare e trasmettere la live. Abbiamo provato a caricarlo e la live ha funzionato. 

4. Mentre cercavamo di implementare la funzione di apertura automatica della live al pulsante, abbiamo dovuto affrontare il problema riguardante il lanciare uno script, `batch` per Windows e `bash` per Mac, che permettesse l'esecuzione del comando per avviare `Nodejs`. Con il seguente codice abbiamo implementato non solo un modo di lanciare gli script ma di lanciare lo script giusto in base al sistema operativo in uso:

```java
    public void script() throws IOException {
        String os= System.getProperty("os.name").toLowerCase();
        if (os.contains("os")) {
             
          
            
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("sh","-c","./RunLiveMac.sh");
            Process process=builder.start();
        } else {
            String path = "cmd /c start RunLiveWin.bat";
            Runtime rn = Runtime.getRuntime();
            Process pr = rn.exec(path);
        }
    }
```

Per quanto riguarda Windows l'istruzione ha funzionato immediatamente. Ma per Mac è stato un processo lungo arrivare alla soluzione funzionante. Anche provando con diverse varianti di script da eseguire, non riuscivamo in alcun modo a far partire `Nodejs`. Una volta perché non veniva trovato il file, perché eravamo nella cartella sbagliata, oppure per altri problemi. Infine, con il docente, abbiamo proceduto passo passo, arrivando ad indentificare in NetBeans il problema. Lo script infatti veniva eseguito correttamente, ma funzionava solo se lanciato da Shell. Come ultima spiaggia ci è venuto in mente di concedere tutti i permessi a NetBeans. Per questo, una volta recati nelle impostazioni del Mac abbiamo dato ***accesso completo al disco** a NetBeans. In questo modo il problema si è risolto. Per completezza riportiamo lo script `bash` in questione.

```bash
cd tello-live-Nodejs
chmod +x index.js
node index.js
```

5.Anche una volta sistemata la questione script, si è presentato un problema, questa volta su Windows. Infatti la live non si attivava dal pulsante se lanciata da un `Jar`. Sospettiamo ci sia un problema con il firewall, ma dobbiamo approfondire.
6.Infine, abbiamo provato a genare il file `Jar`, ma il file era pesantemente corrotto, con componenti che mancano o che erano nascosti. Pulendo la soluzione e compilando il `Frame` principale abbiamo identificato il problema in `ImageFrame`.
Quest'ultimo problema è assolutamente da correggere.


## Punto della situazione rispetto alla pianificazione
Siamo leggermente in ritardo, per questo la prossima lezione dobbiamo andare veloci.

## Programma di massima per la prossima giornata di lavoro
- Fix `Jar`.
- Ultimi ritocchi al codice.
- Power Point e ultimi commit.
