
  CMMS(Computerised Maintenance Management System - System zarządzania utrzymaniem ruchu) A
  aplikacja do tworzenia historii awarii oraz obliczania podstawowych wskaźników 


Aplikacja może zinwentaryzować linie produkcyjne.
Aplikacja może zinwentaryzować maszyny i przypisać je do odpowiednich linii.
Aplikacja może zinwentaryzować awarie i wyliczyć podstawowe wskaźniki.


Dostępne komendy:
line [list, add, save, load]
machine [list, add, save, load]
failure [list, add, save, load]
exit
help

<ul>
Polecenie line:
<li>line list - wyświetla listę linii produkcyjnych.</li>
<li>line add [nazwa linii] - dodaje linię do listy</li>
<li>line save - zapisuje listę w pliku</li>
<li>line load - wczytuje listę z pliku</li>
</ul>

<ul>
Polecenie machine
<li>machine list - wyświetla listę maszyn</li>
<li>machine add -l [nazwa linii] -n [nazwa maszyny] -s [numer seryjny] - dodaje maszynę do listy</li>
<li>machine save - zapisuje listę w pliku</li>
<li>machine load - wczytuje listę z pliku</li>
</ul>

<ul>
Polecenie failure
<li>failure list - wyświetla listę awarii</li>
<li>failure add -m [nazwa maszyny] -d [opis] -ds [data rozpoczęcia] -de [data zakończenia] - dodaje awarię do listy</li>
<li>failur save - zapisuje listę w pliku</li>
<li>machine load - wczytuje listę z pliku</li>
</ul>