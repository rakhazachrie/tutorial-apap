import React from "react";
import classes from "./styles.module.css";
import Button from "../button";

const Item = (props) => {
    const { id, title, price, description, category, handleEdit, quantity} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`Stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
        </div>
    );
};
export default Item;
