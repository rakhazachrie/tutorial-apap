import listItems from "../../items.json";
import List from "components/List";
import React, { useState } from "react";
import "./index.css";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import { Fab } from "@material-ui/core";
import ViewStreamIcon from "@mui/icons-material/ViewStream";

function App() {
    const [shopItems, setShopItems] = useState( () => listItems);
    const [cartItems, setCartitems] = useState( () => []);
    const [cartHidden, setCartHidden] = useState(true);
    const [balance, setBalance] = useState(120);

    function updateShopItem(item, inCart) {
        const tempShopItems = [...shopItems];
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        setShopItems(tempShopItems);
    }

    function handleToggle() {
        setCartHidden(!cartHidden);
    }

    function handleAddItemToCart(item) {
        const newItems = [...cartItems];
        const newItem = {...item};
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        if (targetInd < 0) {
            newItem.inCart = true;
            newItems.push(newItem);
            updateShopItem(newItem, true)
        }
        setCartitems(newItems);
    }

    return (
        <div className="container-fluid">
            <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
            <div style={{ position:"fixed", top: 25, right: 25 }}>
                <Fab variant="extended" onClick={handleToggle}>
                    {cartHidden ?
                        <Badge color="secondary" badgeContent={cartItems.length}>
                            <ShoppingCartIcon />
                        </Badge>
                        : <ViewStreamIcon/>}
                </Fab>
            </div>
            <p className="text-center text-secondary text-sm font-italic">
                (this is a <strong>class-based</strong> application)
            </p>
            <p className="text-center text-primary" >Your Balance: <b> {balance} </b> </p>
            <div className="container pt-3">
                <div className="row mt-3">
                    {!cartHidden ? (
                        <div className="col-sm">
                            <List
                                title="My Cart"
                                items={cartItems}
                                onItemClick={() => {}}
                            ></List>
                        </div>
                    ) : <div className="col-sm">
                        <List
                            title="List Items"
                            items={shopItems}
                            onItemClick={handleAddItemToCart}
                            isShopList={true}
                        ></List>
                    </div>}
                </div>
            </div>
        </div>
    );
}

export default App;