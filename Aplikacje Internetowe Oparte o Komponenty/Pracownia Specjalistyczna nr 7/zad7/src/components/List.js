import Item from "./Item";
function List(){
    const listaPrzedmiotow = [
        {id: 1, name: "Patryk"},
        {id: 2, name: "Michał"},
        {id: 3, name: "Magda"},
        {id: 4, name: "Ola"}
    ];
    let lista = [];
    for(let i=0;i<listaPrzedmiotow.length;i++){
        lista.push(<Item id={listaPrzedmiotow[i].id} name={listaPrzedmiotow[i].name}></Item>);
    }
    return(
        <div>
            <h3>To jest lista</h3>
            <ul>
                {lista}
            </ul>
        </div>
    )
}
export default List;