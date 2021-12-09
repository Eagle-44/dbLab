# dbLab

### This is Lab 7 

ЗБЕРЕЖУВАНІ ПРОЦЕДУРИ
1. Забезпечити параметризовану вставку нових значень у 
таблицю Книги.
2. Створити пакет, який вставляє 10 стрічок в таблицю Паролі у 
форматі < Noname+№> , наприклад Noname5, де номер 
генерується випадково. При цьому необхідно перевіряти, щоб 
номери не співпадали з вже існуючими.
3. Використовуючи курсор, забезпечити динамічне створення 
таблиці, що містить стовпці з іменами з таблиці Користувачі. 
Тип стовпців довільний.
КОРИСТУВАЦЬКІ ФУНКЦІЇ
1. Для таблиці Користувачі написати функцію як буде шукати 
AVG стовпця Рейтинг . Потім зробити вибірку даних (SELECT)
більших за середнє значення, використовуючи дану функцію.
2. Написати функцію, яка витягує за ключем між таблицями 
Паролі та Користувачі значення поля Пароль . Потім зробити 
вибірку усіх даних (SELECT) з таблиці Користувачі,
використовуючи дану функцію.
ТРИГЕРИ
1. Забезпечити цілісність значень для структури БД.
2. Користувачі →Логін не повинен розпочинатися з цифри чи 
літери F та бути меншим за 8 символів; 
3. значення Користувачі→ Рейтинг повинно знаходитися у 
межах [1; 5]. 
4. Створити таблицю-журнал, в якій вести логи зі штампом часу 
при модифікації даних для таблиці Книги.


