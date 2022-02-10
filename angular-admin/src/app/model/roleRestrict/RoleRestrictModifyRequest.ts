export class RoleRestrictModifyRequest {

  id:string;//主键ID

  roleId:string;//角色ID

  province:string;//省

  city:string;//市

  district:string;//区

  restrictWay:number;//限定方式（1：本人，本人的话省市区都为self；2：非本人，非本人的话会填充省市区）

}
