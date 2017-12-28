import {Pipe, PipeTransform} from "@angular/core";
import {Player} from "../../models/player.model";

@Pipe({ name: 'positionFilter' })
export class PlayerPositionFilterPipe implements PipeTransform {
  transform(allPlayers: Player[], position: string) {
    return allPlayers.filter(player=>player.position===position);
  }
}
