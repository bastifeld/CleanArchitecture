yieldUnescaped '<!DOCTYPE html>'
html(lang: 'en', 'data-theme': 'dark') {

    head {
        meta('http-equiv': '"Content-Type" content="text/html; charset=utf-8"')
        script(src: 'https://unpkg.com/htmx.org@1.8.6/dist/htmx.js', defer: 'true') {}
        script(src: 'https://unpkg.com/hyperscript.org@0.8.1/dist/_hyperscript.js', defer: 'true') {}
        
        link(rel: 'stylesheet', href: 'https://unpkg.com/todomvc-app-css@2.4.1/index.css') {}
        title('My page')

    }
    body {
        section(class: 'todoapp') {
            header(class: 'header') {
                h1('todos')
                form('hx-post': '/addToDo', 'hx-target': '#todo-list', 'hx-swap': 'innerHTML', '_': 'on htmx:afterOnLoad set #txtTodo.value to ""') {
                    input(id: 'txtTodo', name: 'todo', class: 'new-todo', placeholder: 'What needs to be done?', autofocus: '')
                }
            }
            section(class: 'main') {
                input(id: 'toggle-all', class: 'toggle-all', type: 'checkbox')
                label(for: 'toggle-all', 'Mark as complete')
            }

            ul(id: 'todo-list', class: 'todo-list', 'hx-get': "/items", 'hx-trigger': 'load')
        }
    }

}
