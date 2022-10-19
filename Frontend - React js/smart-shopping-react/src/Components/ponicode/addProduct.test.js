const addProduct = require("../addProduct")
// @ponicode
describe("addProduct.default.addUser", () => {
    let inst

    beforeEach(() => {
        inst = new addProduct.default()
    })

    test("0", () => {
        let result = inst.addUser({ preventDefault: () => true })
        expect(result).toMatchSnapshot()
    })

    test("1", () => {
        let result = inst.addUser({ preventDefault: () => false })
        expect(result).toMatchSnapshot()
    })

    test("2", () => {
        let result = inst.addUser(undefined)
        expect(result).toMatchSnapshot()
    })
})
