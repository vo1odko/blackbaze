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

    // Если меню скрыто (нет класса show) - показываем его
    if (!navbar.classList.contains('show')) {
        navbar.classList.remove('hide');
        navbar.classList.add('show');
        navbar.style.display = 'flex'; // Принудительно показываем меню
        menuToggle.innerHTML = '✖';
        menuToggle.classList.add('active');
    }
    // Если меню показано - скрываем его с анимацией
    else {
        navbar.classList.remove('show');
        navbar.classList.add('hide');
        menuToggle.innerHTML = '☰';
        menuToggle.classList.remove('active');

        // После окончания анимации скрытия убираем display: flex
        navbar.addEventListener('animationend', function handler() {
            if (navbar.classList.contains('hide')) {
                navbar.style.display = 'none';
                navbar.classList.remove('hide');
            }
            navbar.removeEventListener('animationend', handler);
        }, { once: true });
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



// Глобальные переменные для галереи
let currentSlideIndex = 0;
const portfolioItems = document.querySelectorAll('.portfolio-item');

// Открытие модального окна
function openModal(index) {
    currentSlideIndex = index;
    const modal = document.getElementById('portfolioModal');
    const modalImg = document.getElementById('modalImage');
    const captionText = document.getElementById('caption');

    modal.style.display = "block";
    modalImg.src = portfolioItems[index].querySelector('img').src;
    captionText.innerHTML = portfolioItems[index].querySelector('img').alt;
}

// Закрытие модального окна
function closeModal() {
    document.getElementById('portfolioModal').style.display = "none";
}

// Переключение между фото
function changeSlide(n) {
    currentSlideIndex += n;

    // Зацикливаем переключение
    if (currentSlideIndex >= portfolioItems.length) {
        currentSlideIndex = 0;
    } else if (currentSlideIndex < 0) {
        currentSlideIndex = portfolioItems.length - 1;
    }

    const modalImg = document.getElementById('modalImage');
    const captionText = document.getElementById('caption');
    modalImg.src = portfolioItems[currentSlideIndex].querySelector('img').src;
    captionText.innerHTML = portfolioItems[currentSlideIndex].querySelector('img').alt;
}

// Закрытие по клику вне изображения
document.addEventListener('click', function(event) {
    const modal = document.getElementById('portfolioModal');
    if (event.target === modal) {
        closeModal();
    }
});

// Закрытие по клавише Esc
document.onkeydown = function(event) {
    const modal = document.getElementById('portfolioModal');
    if (event.key === "Escape" && modal.style.display === "block") {
        closeModal();
    }
    if (event.key === "ArrowLeft" && modal.style.display === "block") {
        changeSlide(-1);
    }
    if (event.key === "ArrowRight" && modal.style.display === "block") {
        changeSlide(1);
    }
}