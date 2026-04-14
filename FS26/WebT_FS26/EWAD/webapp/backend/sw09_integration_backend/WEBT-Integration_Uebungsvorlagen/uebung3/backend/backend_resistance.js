import express from 'express';
const router = express.Router();

//  calculates total resistance corresponing to wiring
function calculateResistance(r1, r2, wiring) {
    let totalResistance;
    if (wiring == 'serial') {
        totalResistance = r1 + r2;
    } else if (wiring == 'parallel') {
        totalResistance = r1 * r2 / (r1 + r2);
    }
    return totalResistance;
}

// handle request
// TODO: Change to POST
router.get('/', function (req, res) {
    res.type('application/json');

    let error = null;
    // TODO: Parse body to JSON document
    
    // TODO: Obtain values for validation of JSON document from body
    if (!('r1' in req.query)) {
        error = { error: "Parameter 'r1' not set" };
    } else if (!('r2' in req.query)) {
        error = { error: "Parameter 'r2' not set" };
    } else if (!('wiring' in req.query)) {
        error = { error: "Parameter 'wiring' not set" };
    } else if (isNaN(req.query.r1) || parseFloat(req.query.r1) < 0) {
        error = { error: "Invalid value for parameter 'r1'" };
    } else if (isNaN(req.query.r2) || parseFloat(req.query.r2) < 0) {
        error = { error: "Invalid value for parameter 'r2'" };
    } else if (parseFloat(req.query.r1) == 0 && parseFloat(req.query.r2) == 0) {
        error = { error: "r1 and r2 can not both be 0" };
    } else if (req.query.wiring!='serial' && req.query.wiring!='parallel') {
        error = { error: "Invalid value for parameter 'wiring'" };
    }

    if (error) {
        res.status(400);
        res.send(error);
        return;
    }

    // TODO: Obtain values for calculation from body
    let resistance = calculateResistance(parseFloat(req.query.r1), parseFloat(req.query.r2), req.query.wiring);
    let response = { resistance: resistance };

    res.send(JSON.stringify(response));
});

export default router;