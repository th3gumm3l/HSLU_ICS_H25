import express from 'express';
const router = express.Router();

// TODO: Insert calculateResistance function from "Einführung in Javascript"

router.all('/', function (req, res) {
    res.type('application/json');

    let error = null;
    // TODO: Check request parameters r1, r2 and wiring from req.query for 
    // existence and validate for correct data

    if (error) {
        res.status(400);
        res.send(error);
        return;
    }

    // TODO: replace the -1 with the correct call of the funktion calculateResistance()
    let resistance = -1;
    let response = { resistance: resistance };

    res.send(JSON.stringify(response));
});

export default router;