var editor;

$(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
        idSrc:  'idFormasPlantacion',
        ajax: {
            create: {
                'contentType': 'application/json',
                'url': 'crear-forma-plantacion',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            },
            edit: {
                'contentType': 'application/json',
                'url': 'editar-forma-plantacion',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            },
            remove: {
                'contentType': 'application/json',
                'url': 'eliminar-forma-plantacion',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            }
        },
        table: "#listaFormasPlantacion",
        fields: [
            {
                label: "Descripcion:",
                name: "descripcion"
            },
        ]
    } );


    $('#listaFormasPlantacion').DataTable({
        dom: "Bfrtip",
        idSrc:  'idFormasPlantacion',
        "language": {
            url: '/data/datatable-es.json'
        },
        select: true,
        ajax: {
            url: 'formas-plantacion',
            dataSrc: ''
        },
        columns: [
            { data: "descripcion",
                title: "Descripción",
            },
            {
                data: null,
                className: "dt-center editor-edit",
                defaultContent: '<i class="bi bi-pencil"/>',
                orderable: false,
                width: "3%"
            },
            {
                data: null,
                className: "dt-center editor-delete",
                defaultContent: '<i class="bi bi-trash"/>',
                orderable: false,
                width: "3%"
            }
        ],
        buttons: [
            {
                extend: "create",
                editor: editor,
                formTitle: "Crear nueva forma de plantación",
                formButtons: [
                    'Crear',
                    { text: 'Cancelar', action: function () { this.close(); } }
                ]
            },
            {
                extend: "edit",
                editor: editor,
                formTitle: "Modificar forma de plantación",
                formButtons: [
                    'Grabar',
                    { text: 'Cancelar', action: function () { this.close(); } }
                ]
            },
            {
                extend: "remove",
                editor: editor,
                formTitle: "Eliminar forma de plantación",
                formButtons: [
                    'Eliminar',
                    { text: 'Cancelar', action: function () { this.close(); } }
                ]
            },
        ]
    });

    // Editar registro
    $('#listaFormasPlantacion').on('click', 'td.editor-edit', function (e) {
        e.preventDefault();
        editor.edit( $(this).closest('tr'), {
            title: 'Editar registro',
            buttons: [
                'Grabar',
                { label: 'Cancelar', fn: function () { this.close(); } }
            ]
        } );
    } );

    // Eliminar registro
    $('#listaFormasPlantacion').on('click', 'td.editor-delete', function (e) {
        e.preventDefault();
        editor.remove( $(this).closest('tr'), {
            title: 'Eliminar especie',
            message: '¿Seguro que deseas eliminar esta especie?',
            buttons: [
                'Eliminar',
                { label: 'Cancelar', fn: function () { this.close(); } }
            ]
        } );
    } );
} );