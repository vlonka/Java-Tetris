### Rakennekuvaus

Ohjelmassa on luokka ```Ruudukko```, mikä on matriisi jossa voi olla luokan ```Ruutu``` olioita. Tämä kuvaa Tetriksen pelialuetta.

Luokka ```Palikka``` koostuu luokan ```Pala``` olioista ja tämän alaluokat kuvaavat Tetriksen putoavaa palikka, jota pelaaja ohjaa. 
Paloilla on ```int``` arvot ```korkeus``` ja ```leveys``` jotka kuvaavat palikan sijaintia pelialueella, mutta ne eivät ole suoraan tekemisissä 
sen kanssa, paitsi kun palikka tarkastaa onko sen tulevassa sijainnissa mitään ja voiko se oikeastaan liikkua sinne. Palikan alaluokilla 
on ```Vektori```-luokan olioita jotka kertovat yksittäisten palojen liikkumissuunnan palikan pyöriessä. Pyöriminen toteutuu muuttamalla 
palojen paikkaa, palika ei siis sinänsä pyöri mitenkään.

Luokan ```Peli``` on tarkoitus sitoa ```Palikka``` ja ```Ruudukko``` toisiinsa ja pyörittää koko hommaa.
