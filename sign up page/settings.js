document.addEventListener('DOMContentLoaded', () => {
    const darkModeToggle = document.getElementById('darkModeToggle');
    darkModeToggle.addEventListener('change', () => {
        if (darkModeToggle.checked) {
            document.body.classList.add('dark-mode');
        } else {
            document.body.classList.remove('dark-mode');
        }
    });
});

/* CSS for dark mode */
const style = document.createElement('style');
style.innerHTML = `
    body.dark-mode {
        background-color: #121212;
        color: #ffffff;
    }
    body.dark-mode .sidebar {
        background-color: #1e1e1e;
    }
    body.dark-mode .main-content {
        background-color: #1e1e1e;
    }
    body.dark-mode .settings-content {
        background-color: #2e2e2e;
    }
`;
document.head.appendChild(style);
