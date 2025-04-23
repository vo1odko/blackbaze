// Клик по логотипу обновляет страницу
function refreshPage() {
    window.location.reload();
}

// Функция для прокрутки вверх
function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth' // Плавная прокрутка
    });
}

// Показать/скрыть кнопку "вверх"
window.onscroll = function () {
    const scrollButton = document.querySelector('.scroll-to-top');
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
        scrollButton.style.display = "block";
    } else {
        scrollButton.style.display = "none";
    }
};

// Переключение состояния меню
function toggleMenu() {
    const navbar = document.getElementById('navbar');
    const menuToggle = document.getElementById('menu-toggle');

    if (!navbar.classList.contains('show')) {
        navbar.classList.add('show'); // Добавляем класс для анимации показа
        navbar.classList.remove('hide'); // Убираем класс скрытия, если он есть
        menuToggle.innerHTML = '✖'; // Меняем на крестик
        menuToggle.classList.add('active'); // Добавляем активный класс для кнопки
    } else {
        navbar.classList.remove('show'); // Убираем класс показа
        navbar.classList.add('hide'); // Добавляем класс скрытия для анимации
        menuToggle.innerHTML = '☰'; // Меняем обратно на три полоски
        menuToggle.classList.remove('active'); // Убираем активный класс у кнопки
    }
}

// Проверка размера экрана при загрузке страницы и изменении размера окна
function checkScreenSize() {
    const menuToggle = document.getElementById('menu-toggle');

    if (window.innerWidth <= 1000) { // Если ширина меньше или равна 1000px (мобильные устройства)
        menuToggle.style.display = 'block'; // Показываем кнопку переключения меню

        const headerContainer = document.querySelector('.header-container');

        // Применяем вертикальное расположение элементов при малом размере экрана.
        headerContainer.classList.add("vertical");

        document.getElementById('navbar').style.display = 'none'; // Скрываем навигацию по умолчанию

    } else {
        menuToggle.style.display = 'none'; // Скрываем кнопку переключения меню на больших экранах

        const headerContainer = document.querySelector('.header-container');

        // Применяем горизонтальное расположение элементов при большом размере экрана.
        headerContainer.classList.remove("vertical");

        document.getElementById('navbar').style.display = 'flex'; // Показываем навигацию по умолчанию на больших экранах

    }
}

// Добавление обработчика события клика для кнопки гамбургера после загрузки страницы.
window.onload = function () {
    checkScreenSize();

    const menuToggleButton = document.getElementById("menu-toggle");

    if (menuToggleButton) {
        menuToggleButton.addEventListener("click", toggleMenu);
    }
};

window.onresize = checkScreenSize; // Проверяем размер окна при изменении размера экрана