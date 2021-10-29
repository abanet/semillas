var editor;

$(document).ready(function() {
    editor = new $.fn.dataTable.Editor( {
        idSrc:  'idvariedad',
        ajax: {
            create: {
                'contentType': 'application/json',
                'url': 'crear-variedad',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            },
            edit: {
                'contentType': 'application/json',
                'url': 'editar-variedad',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            },
            remove: {
                'contentType': 'application/json',
                'url': 'eliminar-variedad',
                'type': 'POST',
                'data': function (d) {
                    return JSON.stringify(d);
                }
            }
        },
        table: "#listaVariedades",

        fields: [ {
            label: "Código:",
            name: "codigo"
        }, {
            label: "Nombre:",
            name: "nombre"
        },
            {
            label: "Especie",
            name: "especie",
            type: "select",
            placeholder: "Selecciona la especie"
        }
        ]
    } );


    $('#listaVariedades').DataTable({
        dom: "Bfrtip",
        idSrc:  'idVariedad',
        "language": {
            url: '/data/datatable-es.json'
        },
        select: true,
        ajax: {
            url: 'variedades',
            dataSrc: ''
        },
        columns: [
            { data: "codigo",
                title: "Código",
            },
            { data: "nombre",
                title: "Nombre",
            },
            { data: "especie.nombre",
                title: "Especie",
            },
        ],
        buttons: [
            { extend: "create",
                editor: editor,
                formTitle: "Creando nueva variedad",
                formButtons: [
                    'Crear',
                    { text: 'Cancelar', action: function () { this.close(); } }
                ]},
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

    // Carga de especies

    var listaEspecies = [];
    $.getJSON(window.location.origin + '/especies/especies', {
            term: "-1"
        },
        function(data) {
            var especie = {};
            $.each(data, function(i, e) {
                especie.label = e.nombre;
                especie.value = e.idEspecie;
                listaEspecies.push(especie);
                especie = {};
            });


        }
    ).done(function() {
        editor.field('especie').update(listaEspecies);
    });
    // -- carga de especies


} );