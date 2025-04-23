document.addEventListener('DOMContentLoaded', function() {
    // Инициализация элементов
    const scrollButton = document.querySelector('.scroll-to-top');
    const menuToggle = document.getElementById('menu-toggle');
    const navbar = document.getElementById('navbar');
    const headerContainer = document.querySelector('.header-container');
    
    // Обновление страницы по клику на логотип
    function refreshPage() {
        window.location.reload();
    }
    
    // Прокрутка к верху страницы
    function scrollToTop() {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    }
    
    // Управление видимостью кнопки "Наверх"
    function handleScroll() {
        if (window.scrollY > 100) {
            scrollButton.style.display = "flex"; // Изменено на flex для центрирования иконки
        } else {
            scrollButton.style.display = "none";
        }
    }
    
    // Переключение мобильного меню
    function toggleMenu() {
        const isMenuVisible = navbar.classList.contains('show');
        
        if (!isMenuVisible) {
            navbar.classList.add('show');
            navbar.classList.remove('hide');
            menuToggle.innerHTML = '✖';
            menuToggle.classList.add('active');
            document.body.style.overflow = 'hidden'; // Блокируем скролл страницы
        } else {
            navbar.classList.remove('show');
            navbar.classList.add('hide');
            menuToggle.innerHTML = '☰';
            menuToggle.classList.remove('active');
            document.body.style.overflow = ''; // Восстанавливаем скролл
        }
    }
    
    // Адаптация под размер экрана
    function checkScreenSize() {
        const isMobile = window.innerWidth <= 1000;
        
        menuToggle.style.display = isMobile ? 'block' : 'none';
        headerContainer.classList.toggle('vertical', isMobile);
        
        if (isMobile) {
            navbar.style.display = 'none';
            navbar.classList.remove('show', 'hide');
            menuToggle.innerHTML = '☰';
            menuToggle.classList.remove('active');
        } else {
            navbar.style.display = 'flex';
            document.body.style.overflow = ''; // На десктопе всегда разблокируем скролл
        }
    }
    
    // Закрытие меню при клике на ссылку (для мобильной версии)
    function setupNavLinks() {
        const navLinks = document.querySelectorAll('nav a');
        navLinks.forEach(link => {
            link.addEventListener('click', function() {
                if (window.innerWidth <= 1000) {
                    toggleMenu();
                }
            });
        });
    }
    
    // Инициализация событий
    function init() {
        // Назначение обработчиков
        if (document.querySelector('.logo')) {
            document.querySelector('.logo').addEventListener('click', refreshPage);
        }
        
        if (scrollButton) {
            scrollButton.addEventListener('click', scrollToTop);
            window.addEventListener('scroll', handleScroll);
        }
        
        if (menuToggle) {
            menuToggle.addEventListener('click', toggleMenu);
        }
        
        setupNavLinks();
        checkScreenSize();
    }
    
    // Запуск инициализации
    init();
    
    // Реакция на изменение размера окна
    let resizeTimer;
    window.addEventListener('resize', function() {
        clearTimeout(resizeTimer);
        resizeTimer = setTimeout(function() {
            checkScreenSize();
        }, 250); // Дебаунс 250мс
    });
});