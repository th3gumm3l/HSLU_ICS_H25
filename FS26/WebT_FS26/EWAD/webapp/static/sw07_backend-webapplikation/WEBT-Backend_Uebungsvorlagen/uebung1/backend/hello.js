import express from 'express';
const router = express.Router();

router.get('/', function(req, res) {
    res.type('text/html');

    // TODO: Implement error handling in case of 
    // missing 'name'-parameter
    let name = req.query.name;
    // TODO: Implement the reply using a Template literal
    res.send("Hallo "+name+"!");
});

export default router;