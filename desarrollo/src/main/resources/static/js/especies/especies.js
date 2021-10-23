var editor;

$(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
        idSrc:  'idEspecie',
        ajax: {
            create: {
                'contentType': 'application/json',
                'url': 'crear-especie',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            },
            edit: {
                'contentType': 'application/json',
                'url': 'editar-especie',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            },
            remove: {
                'contentType': 'application/json',
                'url': 'eliminar-especie',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            }
        },
        table: "#listaEspecies",
        fields: [
           {
            label: "Nombre:",
            name: "nombre"
        },
        ]
    } );


    $('#listaEspecies').DataTable({
        dom: "Bfrtip",
        idSrc:  'idEspecie',
        "language": {
            url: '/data/datatableSpain.json'
        },
        select: true,
        ajax: {
            url: 'especies',
            dataSrc: ''
        },
        columns: [
            { data: "nombre",
              title: "Nombre",
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
            { extend: "create", editor: editor },
            { extend: "edit",   editor: editor },
            { extend: "remove", editor: editor },
        ]
    });

    // Editar registro
    $('#listaEspecies').on('click', 'td.editor-edit', function (e) {
        e.preventDefault();

        editor.edit( $(this).closest('tr'), {
            title: 'Editar registro',
            buttons: 'Actualizar'
        } );
    } );

    // Eliminar registro
    $('#listaEspecies').on('click', 'td.editor-delete', function (e) {
        e.preventDefault();

        editor.remove( $(this).closest('tr'), {
            title: 'Eliminar especie',
            message: '¿Seguro que deseas eliminar esta especie?',
            buttons: 'Eliminar'
        } );
    } );
} );