function initComparisons() {
    const containers = document.querySelectorAll('.img-comp-container');

    containers.forEach(container => {
        const overlay = container.querySelector('.img-comp-overlay');
        const slider = container.querySelector('.img-comp-slider');
        const sliderWrapper = container.querySelector('.img-comp-slider-wrapper');

        let isDragging = false;
        const sliderWidth = parseInt(getComputedStyle(slider).width);

        // Инициализация позиции
        const initPosition = container.offsetWidth / 2;
        sliderWrapper.style.left = `${initPosition}px`;
        overlay.style.clipPath = `inset(0 0 0 ${initPosition}px)`;

        // Обработчики для мыши
        slider.addEventListener('mousedown', function(e) {
            isDragging = true;
            slider.style.opacity = '0.9';
            e.preventDefault();
        });

        window.addEventListener('mousemove', function(e) {
            if (!isDragging) return;

            const containerRect = container.getBoundingClientRect();
            let x = e.clientX - containerRect.left;

            // Ограничение границ с учётом центровки слайдера
            x = Math.max(sliderWidth/2, Math.min(x, containerRect.width - sliderWidth/2));

            sliderWrapper.style.left = `${x}px`;
            overlay.style.clipPath = `inset(0 0 0 ${x}px)`;
        });

        window.addEventListener('mouseup', function() {
            isDragging = false;
            slider.style.opacity = '';
        });

        // Обработчики для touch
        slider.addEventListener('touchstart', function(e) {
            isDragging = true;
            slider.style.opacity = '0.9';
            e.preventDefault();
        });

        window.addEventListener('touchmove', function(e) {
            if (!isDragging) return;

            const containerRect = container.getBoundingClientRect();
            let x = e.touches[0].clientX - containerRect.left;

            x = Math.max(sliderWidth/2, Math.min(x, containerRect.width - sliderWidth/2));

            sliderWrapper.style.left = `${x}px`;
            overlay.style.clipPath = `inset(0 0 0 ${x}px)`;
        });

        window.addEventListener('touchend', function() {
            isDragging = false;
            slider.style.opacity = '';
        });
    });
}

document.addEventListener("DOMContentLoaded", initComparisons);