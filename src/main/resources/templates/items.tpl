toDoItems.each { item ->
    li(id: item.id(), class: 'editing') {
        div(id: 'view') {
            input(class: 'toggle', type: 'checkbox')
            label() {
                form('hx-patch': '/update/' + item.id, 'hx-swap': 'innerHTML ', 'hx-target': '#todo-list') {
                    input(class: 'edit', type: 'edit', name: 'name', value: item.toDo())
                }
            }
        }
    }
}



