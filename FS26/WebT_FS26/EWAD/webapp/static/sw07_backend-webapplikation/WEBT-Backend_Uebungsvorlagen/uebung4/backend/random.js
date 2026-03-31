import express from 'express';
const router = express.Router();

router.all('/', function (req, res) {
    res.type('application/json');

    let random = Math.random() * 100;

    // TODO: determine the color based on the random number

    // TODO: return the answer according to the slides as JSON object
});

export default router;