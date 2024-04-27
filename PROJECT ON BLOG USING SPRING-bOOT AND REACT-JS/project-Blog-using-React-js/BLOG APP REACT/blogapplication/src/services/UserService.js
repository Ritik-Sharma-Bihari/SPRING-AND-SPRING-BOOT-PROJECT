import { MyAxios } from "./Helper";

export const signup = (user) => {

    return MyAxios.post('/api/v1/register', user).then((res) => res.data)
}