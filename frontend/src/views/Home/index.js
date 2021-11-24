import React from "react";
import listItems from "../../items.json";
import List from "../../components/List/index";
import "./index.css";
import { Badge } from "@mui/material";
import { Fab } from "@material-ui/core"
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import ViewStreamIcon from "@mui/icons-material/ViewStream";

export default class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120,
        };
    }
    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <div style={{ position:"fixed", top: 25, right: 25 }}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon />
                            </Badge>
                            : <ViewStreamIcon/>}
                    </Fab>
                </div>
                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <p className="text-center text-primary" >Your Balance: <b> {this.state.balance} </b> </p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleRemoveItemToCart}
                                ></List>
                            </div>
                        ) : <div className="col-sm">
                            <List
                                title="List Items"
                                items={this.state.shopItems}
                                onItemClick={this.handleAddItemToCart}
                                isShopList={true}
                            ></List>
                        </div>}
                    </div>
                </div>
            </div>
        );
    }
    handleAddItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        const balance = [this.state.balance];

        const newBalance = balance - newItem.price
        if (newBalance < 0) {
            alert("Balance not sufficient!");
        }
        else{
            if (targetInd < 0) {
                newItem.inCart = true;
                newItems.push(newItem);
                this.updateShopItem(newItem, true)
            }
            this.setState({ cartItems: newItems });
            this.setState({balance: parseFloat(newBalance.toFixed(2))});
        }

    };

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
    };

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    };

    handleRemoveItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const removeItem = { ...item };
        const balance = [this.state.balance];
        const newBalance = parseFloat(balance) + parseFloat(removeItem.price.toFixed(2))
        // var idx = newItems.indexOf(removeItem);
        // newItems.splice(idx, 1)
        removeItem.inCart = false;
        this.updateShopItem(removeItem, false);
        this.setState({cartItems:newItems.filter((it) => it.id != removeItem.id)});
        this.setState({balance:newBalance});

    }
}