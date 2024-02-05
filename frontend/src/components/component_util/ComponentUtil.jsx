import { CancelRounded, CheckCircleRounded, Visibility, VisibilityOff } from "@mui/icons-material"



export const ErrorIcon = ({checkIconValidation,cancelIconValidation}) => (
    <>
        <span className={checkIconValidation ? "valid" : "hide"}>
            <CheckCircleRounded className="valid__icon"/>
        </span>
        <span className={cancelIconValidation ? "hide" : "invalid"}>
            <CancelRounded className="invalid__icon"/>
        </span>
    </>
)

export const VisibilityIcon = ({passwordHidden,setPasswordHidden}) => (
    <>
        <span onClick={() => setPasswordHidden(!passwordHidden)} className={ passwordHidden ? "pwd_hidden" : "hide"}>
            <Visibility className="pwd_hidden__icon"/>
        </span>

        <span onClick={() => setPasswordHidden(!passwordHidden)} className={ passwordHidden ? "hide" : "pwd_hidden"}>
            <VisibilityOff className="pwd_hidden__icon"/>
        </span>
    </>
)

